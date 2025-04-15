package co.edu.uco.burstcar.solicitante;

import co.edu.uco.burstcar.solicitante.infraestructura.config.general.token.PropiedadesConfiguracionJwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(PropiedadesConfiguracionJwt.class)
public class SolicitanteApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SolicitanteApplication.class, args);
    }

}
