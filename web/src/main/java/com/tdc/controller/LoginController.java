package com.tdc.controller;

import com.tdc.domain.User;
import com.tdc.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @GetMapping("/login")
    public String loginPage(@ModelAttribute("user") @RequestBody User user){
        return "login";
    }

    @PostMapping("/login")
    public String showLoginPage( User user){
        String view="login";
        boolean IsLogged=loginService.login(user.getUsername(), user.getPassword());
        if(IsLogged){
            view="index";//You have to redirect according to the ....
        }
        return view;
    }
}
