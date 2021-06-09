package com.example.springasync.sevices;

import com.example.springasync.entities.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTacoMessagingService implements TacoMessagingService {

    @Autowired
    private KafkaTemplate<String, Taco> kafkaTemplate;

    @Override
    public void sendTaco(Taco taco) {
        kafkaTemplate.sendDefault(taco);
    }
}
