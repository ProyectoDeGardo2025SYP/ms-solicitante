package co.edu.uco.burstcar.solicitante.aplicacion.mapeador;

public interface MapeadorAplicacion<A, D> {
    D aDominio(A dto);
}
