package com.service;

import com.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    String kafkaTopic = "newTopic";

    public void send(User user) {
        LOG.info("Sending User Json Serializer : {}", user);
        kafkaTemplate.send(kafkaTopic, user);
    }
}
