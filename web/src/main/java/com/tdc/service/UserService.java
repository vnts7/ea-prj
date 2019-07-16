package com.tdc.service;

import com.tdc.domain.Notification;
import com.tdc.domain.User;
import com.tdc.domain.UserLike;
import com.tdc.repo.NotificationRepo;
import com.tdc.repo.UserLikeRepo;
import com.tdc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo ur;

    @Autowired
    private UserLikeRepo ulr;

    @Autowired
    private NotificationRepo nr;

    public List<User> findAllMatch(Long id){
        List<User> r = new ArrayList<>();
        List<User> likeme = ur.findAllLikeMe(id);
        if(likeme!=null)
        {
            List<User> ilike = ur.findAllILike(id);
            HashMap<Long, User> map = new HashMap<>();
            for (User u: ilike){
                map.put(u.getId(),u);
            }
            for(User u: likeme){
                if(map.containsKey(u.getId()))
                    r.add(u);
            }
        }
        return r;
    }

    public User next(Long id){
        List<User> l = ur.next(id);
        if(l.size()>0)return l.get(0);
        return null;
    }

    //return true if match
    public Boolean like(Long id, Long likeeId, Boolean liked){
        User liker = ur.findById(id).get();
        User likee = ur.findById(likeeId).get();
        ulr.save(
                new UserLike(null, liker, likee, liked)
        );
        if(liked){
            Boolean match = ulr.queryCount(likeeId,id, true)>0;
            if(match){
                //todo: use messaging
                Notification n = new Notification(null, String.format("You have new match with <b>%s</b>.",liker.getName() ), likee, liker );
                nr.save(n);
                likee.setNumNotification(likee.getNumNotification()+1);
                ur.save(likee);
            }
                return match;
        }
        return false;
    }

    public User findByUsername(String username){
        return ur.findByUsername(username);
    }

    public User findById(Long id){
        return ur.findById(id).get();
    }

    public void save(User user){
        ur.save(user);
    }
}
