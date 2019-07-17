package com.tdc.messaging;

import com.tdc.domain.Match;
import com.tdc.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "match")
public class MatchListener {

    @Autowired
    private UserService us;

    @RabbitHandler
    public void save(@Payload Match m) {
        System.out.println("--------MESSAGING received: " + m);
        try {
            us.pushMatchNotification(m);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
