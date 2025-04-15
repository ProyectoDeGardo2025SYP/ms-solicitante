package co.edu.uco.burstcar.solicitante.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitanteEmisorDto implements Serializable {
    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private Long numeroTelefonico;
    private String nombreIdentificacion;
    private String tipoIdentificacion;
    private UUID codigoIdentificador;
}
