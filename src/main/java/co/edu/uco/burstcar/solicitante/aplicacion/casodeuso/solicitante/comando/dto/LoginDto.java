package co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto;

import co.edu.uco.burstcar.solicitante.dominio.modelo.EntidadIdentificador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto extends EntidadIdentificador {

    private String usuario;

    private String contrasena;
}
