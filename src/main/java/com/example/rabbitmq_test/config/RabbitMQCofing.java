package com.example.rabbitmq_test.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

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


}
