package com.tdc.controller;

import com.tdc.domain.User;
import com.tdc.service.UserService;
import com.tdc.service.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {
    @Autowired
//    protected UserServiceProxy us;
    protected UserService us;
    private User user;
    protected User getUser(){
//        if(user!=null)return user;
        String un = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("-------------------" + un);
        if(!un.isEmpty())
        {
            user = us.findByUsername(un);
        }
//        System.out.println(user);
        return user;
    }
    @ModelAttribute("auth")
    private User auth(){
        return getUser();
    }
}
