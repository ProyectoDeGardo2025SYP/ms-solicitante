package co.edu.uco.burstcar.solicitante.aplicacion.casodeuso;

public class DtoResponse <T> {

    private T valor;

    public DtoResponse() {}

    public DtoResponse(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
}
