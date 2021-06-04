package com.example.springasync.sevices;

import com.example.springasync.entities.Taco;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TacoListener {
    @RabbitListener(queues = "")
    public void receiveTaco(Taco taco) {
        log.info("Rabbit -> Got Taco[{}]", taco);
    }

    @KafkaListener(topics = "")
    public void handleKafka(Taco taco) {
        log.info("Kafka -> Got Taco[{}]", taco);
    }

    @KafkaListener(topics = "")
    public void handleKafka(Taco taco, ConsumerRecord<String, Taco> record) {
        log.info("Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());
        log.info("Kafka -> Got Taco[{}]", taco);
    }

    @KafkaListener(topics="")
    public void handle(Taco taco, Message<Taco> message) {
        MessageHeaders headers = message.getHeaders();
        log.info("Received from partition {} with timestamp {}",
                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
        log.info("Kafka -> Got Taco[{}]", taco);
    }
}
