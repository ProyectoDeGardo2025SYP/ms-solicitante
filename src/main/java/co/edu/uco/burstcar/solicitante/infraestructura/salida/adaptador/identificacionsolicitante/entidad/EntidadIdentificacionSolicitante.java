package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.entidad;

import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "identificacion_solicitante", schema = "solicitante")
public class EntidadIdentificacionSolicitante extends EntidadIdentificador {

    @Column(length = 30)
    private String nombre;

    @Column(length = 5)
    private String identificacionCategoriaId;

    public EntidadIdentificacionSolicitante() {
    }
}
