package co.edu.uco.burstcar.solicitante.infraestructura.entrada.solicitante.consulta;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.consulta.CasoDeUsoConsultarSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteConsulta;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitante")
public class ConsultaControladorSolicitante {

    private final CasoDeUsoConsultarSolicitante casoDeUsoConsultarSolicitante;

    public ConsultaControladorSolicitante(CasoDeUsoConsultarSolicitante casoDeUsoConsultarSolicitante) {
        this.casoDeUsoConsultarSolicitante = casoDeUsoConsultarSolicitante;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public SolicitanteConsulta consultarSolicitante(@PathVariable String id){
        return this.casoDeUsoConsultarSolicitante.ejecutarConsulta(id);
    }


}
