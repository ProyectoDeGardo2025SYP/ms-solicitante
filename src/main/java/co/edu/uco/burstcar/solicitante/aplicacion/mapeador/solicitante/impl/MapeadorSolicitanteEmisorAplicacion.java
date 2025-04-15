package co.edu.uco.burstcar.solicitante.aplicacion.mapeador.solicitante.impl;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.solicitante.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteEmisorDto;
import co.edu.uco.burstcar.solicitante.dominio.modelo.IdentificacionSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioIdentificacionSolicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MapeadorSolicitanteEmisorAplicacion implements MapeadorAplicacion<SolicitanteDto, SolicitanteEmisorDto> {

    @Autowired
    private RepositorioIdentificacionSolicitante repositorioIdentificacionSolicitante;

    @Override
    public SolicitanteEmisorDto aDominio(SolicitanteDto dto) {
        IdentificacionSolicitante identificacionSolicitante =
                this.repositorioIdentificacionSolicitante.asociarTipoIdentificacionPrestador(dto.getCategoriaIdentificador());
        return new SolicitanteEmisorDto(dto.getNumeroIdentificacion(), dto.getNombre(), dto.getUsuario(), dto.getNumeroTelefonico(),
                identificacionSolicitante.getNombre(), identificacionSolicitante.getIdentificacionCategoriaId(),
                identificacionSolicitante.getIdentificador());
    }
}
