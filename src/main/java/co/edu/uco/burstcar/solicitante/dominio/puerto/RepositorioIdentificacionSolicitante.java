package co.edu.uco.burstcar.solicitante.dominio.puerto;

import co.edu.uco.burstcar.solicitante.dominio.modelo.IdentificacionSolicitante;

public interface RepositorioIdentificacionSolicitante {

    IdentificacionSolicitante asociarTipoIdentificacionPrestador(String codigo);
}
