package co.edu.uco.burstcar.solicitante.infraestructura.config.general.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionSolicitanteRabbit {

    private final PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit;

    public ConfiguracionSolicitanteRabbit(PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit) {
        this.propiedadesConfiguracionRabbit = propiedadesConfiguracionRabbit;
    }

    @Bean
    public TopicExchange solicitanteExchange() {
        return new TopicExchange(propiedadesConfiguracionRabbit.getExchange());
    }

    @Bean
    public Queue colaSolicitante() {
        return new Queue(propiedadesConfiguracionRabbit.getCola(), true);
    }

    @Bean
    public Binding enlace() {
        return BindingBuilder
                .bind(colaSolicitante())
                .to(solicitanteExchange())
                .with(propiedadesConfiguracionRabbit.getClave());
    }

    @Bean
    public MessageConverter conversorAJson() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitClienteEnvio(ConnectionFactory conexion, MessageConverter mesanje) {
        RabbitTemplate plantilla = new RabbitTemplate(conexion);
        plantilla.setMessageConverter(mesanje);
        return plantilla;
    }
}
