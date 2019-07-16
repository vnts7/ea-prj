package com.tdc.controller;

import com.tdc.domain.Photo;
import com.tdc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @GetMapping("/find")
    public String find(Principal p, Model m) {
        User u = new User();
        u.setName("Handsome Mohamed");
        u.setBio("Very handsome");
        u.setDateOfBirth(LocalDate.of(1990,2,2));
        u.addPhoto(new Photo(123L, null));
        m.addAttribute("user", u);
        return "find";
    }

    @PostMapping("/find")
    public String postLike(Integer action, Principal p){
        System.out.println(action + "--------");
        return "redirect:/find";
    }

    @GetMapping("/match")
    public String getMatch(Long id, Principal p, Model m) {
        m.addAttribute("selected", id);
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setId(1L);
        u.setName("The beauty");
        u.setBio("Very beautiful");
        u.setContact("Contact me at 641 888 888");
        u.setDateOfBirth(LocalDate.of(1990,2,2));
        u.addPhoto(new Photo(234L, null));
        list.add(u);

        u = new User();
        u.setId(2L);
        u.setName("The beauty 2");
        u.setBio("Very beautiful");
        u.setContact("Contact me at 641 888 888");
        u.setDateOfBirth(LocalDate.of(1990,2,2));
        u.addPhoto(new Photo(234L, null));
        list.add(u);
        m.addAttribute("list", list);
        return "match";
    }
}
