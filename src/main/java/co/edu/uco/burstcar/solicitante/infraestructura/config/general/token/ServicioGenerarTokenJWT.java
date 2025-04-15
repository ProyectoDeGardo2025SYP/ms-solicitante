package co.edu.uco.burstcar.solicitante.infraestructura.config.general.token;

import co.edu.uco.burstcar.solicitante.dominio.servicio.token.ServicioGenerarToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Component
public class ServicioGenerarTokenJWT implements ServicioGenerarToken {

    private final KeyPair llave;

    public ServicioGenerarTokenJWT(ConfiguracionJwt configuracionJwt) {
        this.llave = configuracionJwt.obtenerLlave();
    }


    private static Date createDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public String generarToken(String user, String rol) {

        return Jwts.builder()
                .setIssuer("ms-solicitante")
                .setSubject(user)
                .claim("rol", rol)
                .setIssuedAt(createDate(LocalDateTime.now()))
                .setExpiration(createDate(LocalDateTime.now().plusHours(1)))
                .setId(UUID.randomUUID().toString())
                .signWith(this.llave.getPrivate(), SignatureAlgorithm.RS256)
                .compact();
    }
}
