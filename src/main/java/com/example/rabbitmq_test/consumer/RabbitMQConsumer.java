//package com.example.rabbitmq_test.consumer;
//
//import com.example.rabbitmq_test.config.MyWebSocketHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Service
//public class RabbitMQConsumer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
//
//    @Autowired
//    private MyWebSocketHandler webSocketHandler;
//
//    @RabbitListener(queues = "${rabbitmq.queue.name}")
//    public void consumeMessage(String message) {
//        LOGGER.info("Message received: {}", message);
//        try {
//            webSocketHandler.broadcastMessage(message);
//        } catch (Exception e) {
//            LOGGER.error("Error broadcasting message: ", e);
//        }
//    }
//}