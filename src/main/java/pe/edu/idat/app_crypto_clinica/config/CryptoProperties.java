package pe.edu.idat.app_crypto_clinica.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@ConfigurationProperties(prefix = "crypto")
public class CryptoProperties {
    @NotBlank
    private String aesKeyBase64;

}
