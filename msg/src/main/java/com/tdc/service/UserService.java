package com.tdc.service;

import com.tdc.domain.*;
import com.tdc.repo.NotificationRepo;
import com.tdc.repo.UserLikeRepo;
import com.tdc.repo.UserRepo;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo ur;

    @Autowired
    private NotificationRepo nr;



    public void pushMatchNotification(Match m){
        User liker = ur.findById(m.getTarget()).get();
        User likee = ur.findById(m.getReceiver()).get();
        Notification n = new Notification(null, String.format("You have new match with <b>%s</b>.",liker.getName() ), likee, liker );
        nr.save(n);
        likee.setNumNotification(likee.getNumNotification() + 1);
        ur.save(likee);
    }
}
