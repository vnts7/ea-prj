package com.tdc.controller;

import com.tdc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private UserRepo ur;
    @GetMapping("")
    public String index(){
        ur.findAll();
        return "redirect:/find";
    }
}
