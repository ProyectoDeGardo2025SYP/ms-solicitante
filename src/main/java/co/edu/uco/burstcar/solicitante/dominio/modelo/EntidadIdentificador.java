package co.edu.uco.burstcar.solicitante.dominio.modelo;

import java.util.UUID;

public class EntidadIdentificador {
    private final UUID identificador;

    public EntidadIdentificador() {
        this.identificador = UUID.randomUUID();
    }

    public EntidadIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public UUID getIdentificador() {
        return identificador;
    }
}
