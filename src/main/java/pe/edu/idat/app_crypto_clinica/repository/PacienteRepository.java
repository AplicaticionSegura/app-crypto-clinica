package pe.edu.idat.app_crypto_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.app_crypto_clinica.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
