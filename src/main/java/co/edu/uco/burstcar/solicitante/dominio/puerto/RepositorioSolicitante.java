package co.edu.uco.burstcar.solicitante.dominio.puerto;

import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteEmisorDto;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;

public interface RepositorioSolicitante {

    void registrarInformacionPersonal(Solicitante solicitante);
    Solicitante realizarInicioSesion(String usuario, String contrasena);
    boolean validarSolicitante(String numeroIdentificacion);
}
