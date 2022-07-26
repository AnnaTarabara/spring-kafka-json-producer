package com.controller;

import com.model.User;
import com.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka/")
public class UserController {

    @Autowired
    KafkaProducerService kafkaProducer;


    @PostMapping("/producer")
    public String sendMessage(@RequestBody User user)
    {
        kafkaProducer.send(user);
        return "Message sent successfully!";
    }

}
