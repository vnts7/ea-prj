package com.tdc.controller;

import com.tdc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.time.LocalDate;

@Controller
public class ProfileController {

    @GetMapping("/find")
    public String find(Principal p, Model m) {
        User u = new User();
        u.setName("Handsome Mohamed");
        u.setBio("Very handsome");
        u.setDateOfBirth(LocalDate.now());
        m.addAttribute("user", u);
        return "find";
    }



    @GetMapping("/match")
    public String getMatch(Principal p) {

        return "match";
    }
}
