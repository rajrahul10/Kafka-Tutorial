package com.example.EventPublisher.controller;

import com.example.EventPublisher.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventPublisherController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishEvent(@PathVariable String message) {
        try {
            for (int i = 0; i < 10000; i++) {
                publisher.sendMessageToTopic(message + " : " + i);
            }
            return new ResponseEntity<>("Message Published Successfully ...", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Message Published Failed ...", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
