package com.example.EventConsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics="my-topic-002", groupId = "my-group-002")
    public void consume(String message) {
        logger.info("Consumer consume the message: {}", message);
    }
}
