package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.rabbit;

import co.edu.uco.burstcar.solicitante.dominio.dto.SolicitanteEmisorDto;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioEmisionSolicitante;
import co.edu.uco.burstcar.solicitante.infraestructura.config.general.rabbit.PropiedadesConfiguracionRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmitirSolicitanteRabbit implements RepositorioEmisionSolicitante {

    private final RabbitTemplate rabbit;
    private final PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit;

    public EmitirSolicitanteRabbit(RabbitTemplate rabbit, PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit) {
        this.rabbit = rabbit;
        this.propiedadesConfiguracionRabbit = propiedadesConfiguracionRabbit;
    }

    @Override
    public void emitirInformacionSolicitante(SolicitanteEmisorDto emisorDto) {
        this.rabbit.convertAndSend(propiedadesConfiguracionRabbit.getExchange(),
                propiedadesConfiguracionRabbit.getClave(), emisorDto);
    }
}
