package pe.edu.idat.app_crypto_clinica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String dnicifrado;
    private String dniiv;
    private String diagnosticocifrado;
    private String diagnosticoiv;
}
