package co.edu.uco.burstcar.solicitante.dominio.servicio.solicitante;

import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioSolicitante;

public class ServicioRegistrarSolicitante {
    private final RepositorioSolicitante repositorioSolicitante;

    public ServicioRegistrarSolicitante(RepositorioSolicitante repositorioSolicitante) {
        this.repositorioSolicitante = repositorioSolicitante;
    }

    public void ejecutarRegistro(Solicitante solicitante){
        this.repositorioSolicitante.registrarInformacionPersonal(solicitante);
    }
}
