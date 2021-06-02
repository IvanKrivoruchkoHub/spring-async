package com.example.springasync.sevices;

import com.example.springasync.entities.Taco;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class RabbitTacoMessagingService implements TacoMessagingService {

    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter converter;

    public RabbitTacoMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.converter = rabbitTemplate.getMessageConverter();
    }
    @Override
    public void sendTaco(Taco taco) {
//        MessageProperties props = new MessageProperties();
//        props.setHeader("X_ORDER_SOURCE", "WEB");
//        Message message = converter.toMessage(taco, props);
//        rabbitTemplate.send(message);
        rabbitTemplate.convertAndSend(taco, message -> {
            message.getMessageProperties().setHeader("X_ORDER_SOURCE", "WEB");
            return message;
        });
    }
}
