package br.com.marketplace.processamento.controller;

import br.com.marketplace.processamento.service.KafkaAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/processamento/admin")
public class KafkaController {

    @Autowired
    private KafkaAdminService kafkaAdminService;

    @DeleteMapping("/deleteTopic")
    public String deleteTopic(@RequestParam String topicName) {
        kafkaAdminService.deleteTopic(topicName);
        return "Topic deleted";
    }

    @PostMapping("/createTopic")
    public String createTopic(@RequestParam String topicName, @RequestParam int partitions, @RequestParam short replicationFactor) {
        kafkaAdminService.createTopic(topicName, partitions, replicationFactor);
        return "Topic created";
    }
}
