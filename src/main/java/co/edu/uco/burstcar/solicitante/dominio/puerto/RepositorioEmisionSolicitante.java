package co.edu.uco.burstcar.solicitante.dominio.puerto;

import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteEmisorDto;

public interface RepositorioEmisionSolicitante {
    void emitirInformacionSolicitante(SolicitanteEmisorDto emisorDto);

}
