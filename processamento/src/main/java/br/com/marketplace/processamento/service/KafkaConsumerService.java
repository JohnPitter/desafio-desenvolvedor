package br.com.marketplace.processamento.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.marketplace.processamento.model.CustomMessage;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "processamento", groupId = "group_id")
    public void consume(CustomMessage message) {
        try {
            // Process the message
            logger.info("Consumed message: {}", message);
            // Add your message processing logic here
        } catch (Exception e) {
            // Handle the exception
            logger.error("Error processing message: {}", message, e);
            // Optionally, send the message to a dead-letter queue or take other recovery actions
        }
    }
}