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

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private UserRepo ur;

    @Autowired
    private UserLikeRepo ulr;

    @Autowired
    private NotificationRepo nr;

    public List<User> findAllMatch(Long id) {
        List<User> r = new ArrayList<>();
        List<User> likeme = ur.findAllLikeMe(id);
        if (likeme != null) {
            List<User> ilike = ur.findAllILike(id);
            HashMap<Long, User> map = new HashMap<>();
            for (User u : ilike) {
                map.put(u.getId(), u);
            }
            for (User u : likeme) {
                if (map.containsKey(u.getId()))
                    r.add(u);
            }
        }
        return r;
    }

    public User next(Long id) {
        User u = findById(id);
        Filter f = u.getFilter();
        if (f == null) {
            f = new Filter(u.getGender() == 0 ? 1 : 0, 20, u.getAge() - 5, u.getAge() + 5);
            u.setFilter(f);
            ur.save(u);
        }

        LocalDate dateFrom = LocalDate.now().minusYears(f.getAgeTo());
        LocalDate dateTo = LocalDate.now().minusYears(f.getAgeFrom());

        Query q = em.createNativeQuery(
                "select * from User u where u.id<>:id"
                        + " and u.date_Of_Birth>:dateFrom"
                        + " and u.date_Of_Birth<:dateTo"
                        + (f.getInterestedIn() == -1 ? "" : " and u.gender=:interestedIn")
                        + " and u.id not in (select likee_id from user_like where liker_id=:id)"
                , User.class)
                .setParameter("id", id)

                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo)

//                .setFirstResult(0)
                .setMaxResults(1);
        if (f.getInterestedIn() != -1)
            q.setParameter("interestedIn", f.getInterestedIn());
        List<User> l = q.getResultList();
        if (l == null || l.size() == 0) return null;
        return l.get(0);
//        List<User> l = ur.next(id);
//        if(l.size()>0)return l.get(0);
//        return null;
    }

    //return true if match
    public Boolean like(Like l) {
        Long likeeId = l.likee;
        Long likerId = l.liker;
        Boolean liked = l.liked;
        User liker = ur.findById(likerId).get();
        User likee = ur.findById(likeeId).get();
        ulr.save(
                new UserLike(null, liker, likee, liked)
        );
        if (liked) {
            Boolean match = ulr.queryCount(likeeId, likerId, true) > 0;
            if (match) {
                //todo: use messaging
                template.convertAndSend("match", new Match(likeeId, likerId));
//                pushMatchNotification(new Match(likeeId, likerId));
            }
            return match;
        }
        return false;
    }

    public User findByUsername(String username) {
        return ur.findByUsername(username);
    }

    public User findById(Long id) {
        return ur.findById(id).get();
    }

    public Long save(User user) {
        ur.save(user);
        return user.getId();
    }

    public List<Notification> getNotifications(Long id) {
        User u = ur.findById(id).get();
        u.setNumNotification(0);
        ur.save(u);
        return u.getNotifications();
    }

    public void pushMatchNotification(Match m) {
        User liker = ur.findById(m.getTarget()).get();
        User likee = ur.findById(m.getReceiver()).get();
        Notification n = new Notification(null, String.format("You have new match with <b>%s</b>.", liker.getName()), likee, liker);
        nr.save(n);
        likee.setNumNotification(likee.getNumNotification() + 1);
        ur.save(likee);
    }
}
