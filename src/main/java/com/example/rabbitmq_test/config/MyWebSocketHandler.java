package com.example.rabbitmq_test.config;

import com.example.rabbitmq_test.publisher.RabbitMQProducer;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
    private static final List<WebSocketSession> sessions = new ArrayList<>();

    private final RabbitMQProducer rabbitMQProducer;

    public MyWebSocketHandler(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Aquí enviamos el mensaje recibido desde WebSocket a RabbitMQ
        String payload = message.getPayload();
        rabbitMQProducer.sendMsg(payload); // Enviar a RabbitMQ
        session.sendMessage(new TextMessage("Message sent to RabbitMQ: " + payload));
    }

}
