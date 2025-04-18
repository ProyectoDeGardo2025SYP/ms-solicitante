package co.edu.uco.burstcar.solicitante.dominio.servicio.solicitante;

import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteConsulta;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioSolicitante;

public class ServicioConsultarSolicitante {
    private final RepositorioSolicitante repositorioSolicitante;

    public ServicioConsultarSolicitante(RepositorioSolicitante repositorioSolicitante) {
        this.repositorioSolicitante = repositorioSolicitante;
    }

    public SolicitanteConsulta ejecutarConsulta(String id){
        return this.repositorioSolicitante.consultarSolicitante(id);
    }
}
