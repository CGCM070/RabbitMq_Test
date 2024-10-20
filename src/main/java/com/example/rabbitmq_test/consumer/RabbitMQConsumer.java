package com.example.rabbitmq_test.consumer;


import com.example.rabbitmq_test.config.WebSocketSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
    private final WebSocketSessionManager webSocketSessionManager;

    public RabbitMQConsumer(WebSocketSessionManager webSocketSessionManager) {
        this.webSocketSessionManager = webSocketSessionManager;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(String message) {
        LOGGER.info("Message received: {}", message);

        // Enviar mensaje a todos los WebSocket activos
        webSocketSessionManager.broadcastMessage(message);
    }
}
