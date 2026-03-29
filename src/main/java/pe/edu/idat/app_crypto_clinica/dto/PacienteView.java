package pe.edu.idat.app_crypto_clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PacienteView {
    private Long id;
    private String nombre;
    private String dni;
    private String diagnostico;
}
