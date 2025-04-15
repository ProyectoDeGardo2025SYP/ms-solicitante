package co.edu.uco.burstcar.solicitante.infraestructura.config.general.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ServicioValidarTokenJWT implements ServicioValidarToken {

    private final Environment environment;

    public ServicioValidarTokenJWT(Environment environment) {
        this.environment = environment;
    }

    @Override
    public boolean isValid(String token) {
            if(token == null || token.isBlank()) {
                return false;
            }

        SecretKey key = Keys.hmacShaKeyFor(
                this.environment.getRequiredProperty("token.key")
                        .getBytes(StandardCharsets.UTF_8)
        );

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration().after(new Date());
        }
}
