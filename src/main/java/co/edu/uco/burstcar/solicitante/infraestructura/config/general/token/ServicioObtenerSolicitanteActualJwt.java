package co.edu.uco.burstcar.solicitante.infraestructura.config.general.token;

import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteActualDto;
import co.edu.uco.burstcar.solicitante.dominio.servicio.token.ServicioObtenerSolicitanteActual;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class ServicioObtenerSolicitanteActualJwt implements ServicioObtenerSolicitanteActual {

    private String obtenerTokenActual() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }


    @Override
    public SolicitanteActualDto obtener() {
        DecodedJWT decoded = JWT.decode(obtenerTokenActual());
        return new SolicitanteActualDto(decoded.getSubject(),
                decoded.getClaim("rol").asString());

    }
}
