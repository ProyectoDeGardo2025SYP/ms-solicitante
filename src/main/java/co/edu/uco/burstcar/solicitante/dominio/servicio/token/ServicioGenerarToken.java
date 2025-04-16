package co.edu.uco.burstcar.solicitante.dominio.servicio.token;

public interface ServicioGenerarToken {

    String generarToken(String user, String rol);

}
