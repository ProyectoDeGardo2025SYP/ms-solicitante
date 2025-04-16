package co.edu.uco.burstcar.solicitante.infraestructura;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("co.edu.uco.burstcar")
@EnableJpaRepositories(basePackages = "co.edu.uco.burstcar")
public class ApplicationMock {
}
