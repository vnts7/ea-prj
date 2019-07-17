package com.tdc.rest;

import com.tdc.domain.Like;
import com.tdc.domain.Notification;
import com.tdc.domain.User;
import com.tdc.domain.UserLike;
import com.tdc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestProfileController {
    @Autowired
    private UserService us;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return us.findById(id);
    }

    @GetMapping("/user/name/{username}")
    public User findByUsername(@PathVariable String username){
        return us.findByUsername(username);
    }

    @GetMapping("/user/{id}/next")
    public User next(@PathVariable Long id){
        return us.next(id);
    }

    @GetMapping("/user/{id}/match")
    public List<User> findAllMatch(@PathVariable Long id){

        return us.findAllMatch(id);
    }

    @GetMapping("/user/{id}/noti")
    public List<Notification> findAllNoti(@PathVariable Long id){
        return us.getNotifications(id);
    }

    @PostMapping("/user/like")
    public Boolean like(@RequestBody Like like){
        return us.like(like);
    }

    @PostMapping("/user")
    public Long save(@RequestBody User user){
        return us.save(user);
    }



}
