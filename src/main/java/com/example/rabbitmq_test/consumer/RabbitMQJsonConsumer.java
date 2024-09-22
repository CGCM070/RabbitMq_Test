package com.example.rabbitmq_test.consumer;


import com.example.rabbitmq_test.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = "${rabbitmq.json.queue.name}")
    public void consumeJsonMessage(User user) {
        LOGGER.info("JSON  received: {}", user);
    }
}
