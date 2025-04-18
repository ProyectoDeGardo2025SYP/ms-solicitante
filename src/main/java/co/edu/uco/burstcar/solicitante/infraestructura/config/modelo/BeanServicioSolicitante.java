package co.edu.uco.burstcar.solicitante.infraestructura.config.modelo;

import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.servicio.solicitante.ServicioConsultarSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.servicio.solicitante.ServicioRegistrarSolicitante;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioSolicitante {

    @Bean
    public ServicioRegistrarSolicitante servicioRegistrarSolicitante(RepositorioSolicitante repositorioSolicitante){
        return new ServicioRegistrarSolicitante(repositorioSolicitante);
    }

    @Bean
    public ServicioConsultarSolicitante servicioConsultarSolicitante(RepositorioSolicitante repositorioSolicitante){
        return new ServicioConsultarSolicitante(repositorioSolicitante);
    }
}
