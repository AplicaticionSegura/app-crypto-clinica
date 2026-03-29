package pe.edu.idat.app_crypto_clinica.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.app_crypto_clinica.dto.PacienteForm;
import pe.edu.idat.app_crypto_clinica.dto.PacienteView;
import pe.edu.idat.app_crypto_clinica.entity.Paciente;
import pe.edu.idat.app_crypto_clinica.repository.PacienteRepository;

@RequiredArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final CryptoService cryptoService;

    public Paciente guardar(PacienteForm form){
        CryptoService.EncryptedData dniEncrypted =
                cryptoService.encrypt(form.getDni());
        CryptoService.EncryptedData diagnosticoEncrypted =
                cryptoService.encrypt(form.getDiagnostico());
        Paciente newPaciente = new Paciente();
        newPaciente.setNombre(form.getNombre());
        newPaciente.setDnicifrado(dniEncrypted.cipherText());
        newPaciente.setDniiv(dniEncrypted.iv());
        newPaciente.setDiagnosticocifrado(diagnosticoEncrypted.cipherText());
        newPaciente.setDiagnosticoiv(diagnosticoEncrypted.iv());
        return pacienteRepository.save(newPaciente);
    }

    public PacienteView obtenerDetalle(Long id){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        String dni = cryptoService.decrypt(paciente.getDnicifrado(),
                paciente.getDniiv());
        String diagnostico = cryptoService.decrypt(paciente.getDiagnosticocifrado(),
                paciente.getDiagnosticoiv());
        return new PacienteView(paciente.getId(),
                paciente.getNombre(), dni, diagnostico);
    }




}
