package com.example.rabbitmq_test.publisher;


import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String message;

    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMsg(String message) {
        log.info("Sending message -> %s" , message);
        rabbitTemplate.convertAndSend(this.message, this.routingKey, message);
    }
}
