package co.edu.uco.burstcar.solicitante.dominio.puerto;

import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteConsulta;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;

public interface RepositorioSolicitante {

    void registrarInformacionPersonal(Solicitante solicitante);
    Solicitante realizarInicioSesion(String usuario, String contrasena);
    SolicitanteConsulta consultarSolicitante(String numeroIdentificacion);
    boolean validarSolicitante(String numeroIdentificacion);
}
