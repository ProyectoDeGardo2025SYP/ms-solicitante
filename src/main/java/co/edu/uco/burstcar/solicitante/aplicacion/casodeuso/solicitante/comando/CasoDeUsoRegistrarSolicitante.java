package co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.solicitante.aplicacion.mapeador.solicitante.impl.MapeadorSolicitanteAplicacion;
import co.edu.uco.burstcar.solicitante.aplicacion.mapeador.solicitante.impl.MapeadorSolicitanteEmisorAplicacion;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioEmisionSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.servicio.solicitante.ServicioRegistrarSolicitante;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoRegistrarSolicitante {
    private final ServicioRegistrarSolicitante servicioRegistrarSolicitante;
    private final MapeadorSolicitanteAplicacion mapeadorSolicitanteAplicacion;
    private final MapeadorSolicitanteEmisorAplicacion mapeadorSolicitanteEmisorAplicacion;
    private final RepositorioEmisionSolicitante repositorioEmisionSolicitante;

    public CasoDeUsoRegistrarSolicitante(ServicioRegistrarSolicitante servicioRegistrarSolicitante, MapeadorSolicitanteAplicacion mapeadorSolicitanteAplicacion, MapeadorSolicitanteEmisorAplicacion mapeadorSolicitanteEmisorAplicacion, RepositorioEmisionSolicitante repositorioEmisionSolicitante) {
        this.servicioRegistrarSolicitante = servicioRegistrarSolicitante;
        this.mapeadorSolicitanteAplicacion = mapeadorSolicitanteAplicacion;
        this.mapeadorSolicitanteEmisorAplicacion = mapeadorSolicitanteEmisorAplicacion;
        this.repositorioEmisionSolicitante = repositorioEmisionSolicitante;
    }

    public void ejecutarRegistro(SolicitanteDto dto) {
        this.servicioRegistrarSolicitante.ejecutarRegistro
                (this.mapeadorSolicitanteAplicacion.aDominio(dto));
        this.repositorioEmisionSolicitante.emitirInformacionSolicitante(
                this.mapeadorSolicitanteEmisorAplicacion.aDominio(dto));
    }
}