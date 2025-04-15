package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.entidad;

import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.EntidadIdentificador;
import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.entidad.EntidadIdentificacionSolicitante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "solicitante", schema = "solicitante")
public class EntidadSolicitante extends EntidadIdentificador {

    @Column(length = 12)
    private String numeroIdentificacion;
    @Column(length = 30)
    private String nombre;
    @Column(length = 15, nullable = false, unique = true)
    private String usuario;
    @Column(length = 16, nullable = false)
    private String contrasena;
    @Column
    private Long numeroTelefonico;
    @ManyToOne
    @JoinColumn(name = "identificacion_id", referencedColumnName = "identificador")
    private EntidadIdentificacionSolicitante entidadIdentificacionSolicitante;

    public EntidadSolicitante() {
    }

    public EntidadSolicitante(String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, EntidadIdentificacionSolicitante entidadIdentificacionSolicitante) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTelefonico = numeroTelefonico;
        this.entidadIdentificacionSolicitante = entidadIdentificacionSolicitante;
    }
}
