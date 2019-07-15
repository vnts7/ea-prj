package com.tdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @GetMapping("/find")
    public String find(Principal p, Model m) {


        return "find";
    }



    @GetMapping("/match")
    public String getMatch(Principal p) {

        return "match";
    }
}
