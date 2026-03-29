package pe.edu.idat.app_crypto_clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pe.edu.idat.app_crypto_clinica.config.CryptoProperties;

@SpringBootApplication
@EnableConfigurationProperties(CryptoProperties.class)
public class AppCryptoClinicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCryptoClinicaApplication.class, args);
	}

}
