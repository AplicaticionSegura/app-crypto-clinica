package pe.edu.idat.app_crypto_clinica.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.app_crypto_clinica.dto.PacienteForm;
import pe.edu.idat.app_crypto_clinica.dto.PacienteView;
import pe.edu.idat.app_crypto_clinica.entity.Paciente;
import pe.edu.idat.app_crypto_clinica.service.PacienteService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("pacienteForm", new PacienteForm());
        return "paciente/form";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("pacienteForm")
                          PacienteForm pacienteForm,
                          BindingResult bindingResult,
                          Model model){
        if(bindingResult.hasErrors()){
            return "paciente/form";
        }
        Paciente paciente = pacienteService.guardar(pacienteForm);
        return "redirect:/pacientes/"+paciente.getId();
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id,
                             Model model){
        PacienteView paciente = pacienteService.obtenerDetalle(id);
        model.addAttribute("paciente", paciente);
        return "paciente/detalle";
    }

}
