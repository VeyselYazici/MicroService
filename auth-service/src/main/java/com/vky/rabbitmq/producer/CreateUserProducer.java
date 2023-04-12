package com.vky.rabbitmq.producer;

import com.vky.rabbitmq.model.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {
    /**
     * Mesaj iletmek icin rabbit template kullaniyoruz.
     */
    private final RabbitTemplate rabbitTemplate;

    public void sendCreateUserMessage(CreateUser user)
    {
        rabbitTemplate.convertAndSend("exchange-auth","key-auth", user);
    }
}
