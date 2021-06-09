package com.example.springasync.sevices;

import com.example.springasync.entities.Taco;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.core.ParameterizedTypeReference;

public class RabbitTacoReceiver implements TacoReceiver {

    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter converter;

    public RabbitTacoReceiver(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.converter = rabbitTemplate.getMessageConverter();
    }

    @Override
    public Taco receiveTaco() {
//        Message message = rabbitTemplate.receive();
//        return message != null ? (Taco) converter.fromMessage(message) : null;
//        return (Taco) rabbitTemplate.receiveAndConvert();
        return rabbitTemplate.receiveAndConvert(new ParameterizedTypeReference<Taco>() {});
    }
}
