package co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.consulta;

import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteConsulta;
import co.edu.uco.burstcar.solicitante.dominio.servicio.solicitante.ServicioConsultarSolicitante;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoConsultarSolicitante {
    private final ServicioConsultarSolicitante servicioConsultarSolicitante;

    public CasoDeUsoConsultarSolicitante(ServicioConsultarSolicitante servicioConsultarSolicitante) {
        this.servicioConsultarSolicitante = servicioConsultarSolicitante;
    }

    public SolicitanteConsulta ejecutarConsulta(String id) {
        return this.servicioConsultarSolicitante.ejecutarConsulta(id);
    }
}