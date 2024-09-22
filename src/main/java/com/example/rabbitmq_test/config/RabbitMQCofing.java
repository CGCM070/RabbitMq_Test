package com.example.rabbitmq_test.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQCofing {
    /*
        Valores de propiedades de application.properties
        Conection Fctory los configura automaticamente
        Rabbit Template los configura automaticamente
        AmqpAdmin los configura automaticamente
        RabbitAdmin los configura automaticamente
   */

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.json.queue.name}")
    private String jsonQueue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.json.routing.key}")
    private String jsonRoutingKey ;

    // bean para rabbitmq json queue (guarda mensajes en formato json)
    @Bean
    public Queue jsonQueue() {
        return new Queue(jsonQueue);
    }

    // bean para rabbitmq queue
    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    // bean para rabbitmq exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    // Binding para queue e exchange usanandp routing key
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
    }


    // Binding para json queue e exchange usanandp jsonRoutingkey
    @Bean
    public Binding jsonBinding() {
        return BindingBuilder.bind(jsonQueue()).to(exchange()).with(jsonRoutingKey);
    }


    public MessageConverter converter() {
        return  new Jackson2JsonMessageConverter();
    }
    // bean para rabbit template con el converter de mensajes json
    // y la coneccion factory de rabbitmq
    // para enviar mensajes a rabbitmq
    // con el formato de mensajes en json

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
