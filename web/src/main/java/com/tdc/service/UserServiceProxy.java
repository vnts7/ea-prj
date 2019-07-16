package com.tdc.service;

import com.tdc.domain.Notification;
import com.tdc.domain.User;
import com.tdc.domain.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceProxy {
    @Autowired
    private RestTemplate rt;
    private final String restPort = "8080";
    private final String restUrl = "http://localhost:" + restPort + "/api/user/";
    private final String byIdUrl = restUrl + "{id}/";

    public List<User> findAllMatch(Long id) {
        String url = restUrl + id + "/match";
        return rt.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                }).getBody();
    }

    public User next(Long id) {
        String url = byIdUrl + "next";
        return rt.getForObject(url, User.class, id);
    }

    //return true if match
    public Boolean like(Long id, Long likeeId, Boolean liked) {
        String url = byIdUrl + "like/{likeeId}/{liked}";
        return rt.postForObject(url, null, Boolean.class, id, likeeId, liked);
    }

    public User findByUsername(String username) {
        String url = restUrl + "name/" + username;
        return rt.getForObject(url, User.class);
    }

    public User findById(Long id) {
        String url = byIdUrl;
        return rt.getForObject(url, User.class, id);
    }

    public Long save(User user) {
        String url = restUrl;
        return rt.postForObject(url, user, Long.class);
    }

    public List<Notification> getNotifications(Long id){
        String url = restUrl + id + "/noti";
        return rt.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Notification>>() {
                }).getBody();
    }
}
