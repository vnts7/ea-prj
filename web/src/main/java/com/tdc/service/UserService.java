package com.tdc.service;

import com.tdc.domain.User;
import com.tdc.domain.UserLike;
import com.tdc.repo.UserLikeRepo;
import com.tdc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Resource
    private UserRepo ur;

    @Autowired
    private UserLikeRepo ulr;

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

    public void like(Long id, Long likee){
        ulr.save(
                new UserLike(null, ur.findById(id).get(), ur.findById(likee).get(), true)
        );
    }

    public void dislike(Long id, Long likee){
        ulr.save(
                new UserLike(null, ur.findById(id).get(), ur.findById(likee).get(), false)
        );
    }
}
