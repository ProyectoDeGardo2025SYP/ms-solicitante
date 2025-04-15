package co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.DtoResponse;
import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.LoginDto;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.servicio.token.ServicioGenerarToken;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoLoginSolicitante {

    private final ServicioGenerarToken servicioGenerarToken;
    private final RepositorioSolicitante repositorioSolicitante;

    public CasoDeUsoLoginSolicitante(ServicioGenerarToken servicioGenerarToken, RepositorioSolicitante repositorioSolicitante) {
        this.servicioGenerarToken = servicioGenerarToken;
        this.repositorioSolicitante = repositorioSolicitante;
    }

    public DtoResponse<String> ejecutar(LoginDto dto) {

        //String encrypted = this.servicioDeEncriptado.ejecutarEncriptacion(dto.getContrasena());
        Solicitante solicitante = this.repositorioSolicitante.realizarInicioSesion(dto.getUsuario(), dto.getContrasena());

        if(solicitante == null) {
            throw new IllegalStateException("Credenciales incorrectas");
        }

        return new DtoResponse<>(this.servicioGenerarToken.generarToken(dto.getUsuario(), "solicitante"));
    }
}