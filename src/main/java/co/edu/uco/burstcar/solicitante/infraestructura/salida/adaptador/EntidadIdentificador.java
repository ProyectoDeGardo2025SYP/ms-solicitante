package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public class EntidadIdentificador {

    @Id
    @Column(name = "identificador", updatable = false, nullable = false)
    private UUID identificador;

    public EntidadIdentificador() {
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }
}
