package co.edu.uco.burstcar.solicitante.infraestructura.entrada.solicitante.comando;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.DtoResponse;
import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.CasoDeUsoLoginSolicitante;
import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.CasoDeUsoRegistrarSolicitante;
import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.LoginDto;
import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.SolicitanteDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitante")
public class ComandoControladorSolicitante {

    private final CasoDeUsoRegistrarSolicitante casoDeUsoRegistrarSolicitante;
    private final CasoDeUsoLoginSolicitante casoDeUsoLoginSolicitante;

    public ComandoControladorSolicitante(CasoDeUsoRegistrarSolicitante casoDeUsoRegistrarSolicitante, CasoDeUsoLoginSolicitante casoDeUsoLoginSolicitante) {
        this.casoDeUsoRegistrarSolicitante = casoDeUsoRegistrarSolicitante;
        this.casoDeUsoLoginSolicitante = casoDeUsoLoginSolicitante;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nuevo")
    public void registrarSolicitante(@RequestBody SolicitanteDto dto){
        this.casoDeUsoRegistrarSolicitante.ejecutarRegistro(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sesion")
    public DtoResponse<String> iniciarSesion(@RequestBody LoginDto dto){
        return this.casoDeUsoLoginSolicitante.ejecutar(dto);
    }


}
