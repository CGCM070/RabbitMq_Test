package com.example.rabbitmq_test.controller;

import com.example.rabbitmq_test.dto.User;
import com.example.rabbitmq_test.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer producer;

    public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.producer = rabbitMQJsonProducer;
    }

    //localhost:8080/api/v1/publish
    @PostMapping("/publish")
    public ResponseEntity<String>sendJsonMessage (@RequestBody User user) {
        producer.SendJsonMsg(user);
        return ResponseEntity.ok("JSON sent to the RabbitMQ successfully");

    }
}
