package co.edu.uco.burstcar.solicitante.dominio.servicio.token;

import java.util.List;

public interface ServicioGenerarToken {

    String generarToken(String user, String rol);

}
