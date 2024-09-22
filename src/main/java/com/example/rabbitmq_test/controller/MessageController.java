package com.example.rabbitmq_test.controller;


import com.example.rabbitmq_test.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.producer = rabbitMQProducer;
    }

    //localhost:8080/api/v1/publish?message=Hello
    @GetMapping("/publish")
    public ResponseEntity<String>sendMessage (@RequestParam ("message") String message) {
        producer.sendMsg(message);
        return ResponseEntity.ok("Message sent to the RabbitMQ2 successfully");
    }
}
