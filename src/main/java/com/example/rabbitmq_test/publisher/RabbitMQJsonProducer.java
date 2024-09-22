package com.example.rabbitmq_test.publisher;


import com.example.rabbitmq_test.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json.routing.key}")
    private String routingJsongKey;

    private RabbitTemplate rabbitTemplate;


    public void SendJsonMsg (User user){
        LOGGER.info("Sending message: {}", user.toString());
        rabbitTemplate.convertAndSend(exchange, routingJsongKey, user);
    }
}
