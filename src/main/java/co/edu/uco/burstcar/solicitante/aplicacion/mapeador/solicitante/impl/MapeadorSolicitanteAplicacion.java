package co.edu.uco.burstcar.solicitante.aplicacion.mapeador.solicitante.impl;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.solicitante.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioIdentificacionSolicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MapeadorSolicitanteAplicacion implements MapeadorAplicacion<SolicitanteDto, Solicitante> {

    @Autowired
    private RepositorioIdentificacionSolicitante repositorioIdentificacionSolicitante;


    @Override
    public Solicitante aDominio(SolicitanteDto dto) {
        return Solicitante.nuevoSolicitante(dto.getNumeroIdentificacion(), dto.getNombre(), dto.getUsuario(), dto.getContrasena(),
                dto.getNumeroTelefonico(),
                this.repositorioIdentificacionSolicitante.asociarTipoIdentificacionPrestador(dto.getCategoriaIdentificador()));
    }
}
