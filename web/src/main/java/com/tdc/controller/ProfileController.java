package com.tdc.controller;


import com.tdc.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class ProfileController extends BaseController {

    @GetMapping("/find")
    public String find(Model m, ModelMap mm) {

        if (mm.containsAttribute("match")) {
            Long match = (Long) mm.get("match");
            m.addAttribute("m_user", us.findById(match));
        }
        m.addAttribute("user", us.next(getUser().getId()));
        return "find";
    }


    @PostMapping("/find")
    public String postLike(Integer action, Long likee, RedirectAttributes ra) {
        if (us.like(getUser().getId(), likee, action == 1)) {
            ra.addFlashAttribute("match", likee);
        }
        return "redirect:/find";
    }

    @GetMapping("/match")
    public String getMatch(Long id, Model m) {
        m.addAttribute("selected", id);
        m.addAttribute("list", us.findAllMatch(getUser().getId()));
        return "match";
    }

    @GetMapping("/notification")
    public String viewNotification(Model m) {
        User u = us.findById(getUser().getId());
        m.addAttribute("list", u.getNotifications());
        u.setNumNotification(0);
        us.save(u);
        return "notification";
    }
}
