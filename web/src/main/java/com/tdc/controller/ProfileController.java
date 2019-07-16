package com.tdc.controller;

import com.tdc.domain.Photo;
import com.tdc.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController extends BaseController {

    @GetMapping("/find")
    public String find(Principal p, Model m, ModelMap mm) {

        if (mm.containsAttribute("match")) {
            Long match = (Long) mm.get("match");
            m.addAttribute("m_user", us.findById(match));
        }


//        User u = new User();
//        u.setId(2L);
//        u.setName("Handsome Mohamed");
//        u.setBio("Very handsome");
//        u.setDateOfBirth(LocalDate.of(1990, 2, 2));
//        u.addPhoto(new Photo(123L, null));
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
//        List<User> list = new ArrayList<>();
//        User u = new User();
//        u.setId(1L);
//        u.setName("The beauty");
//        u.setBio("Very beautiful");
//        u.setContact("Contact me at 641 888 888");
//        u.setDateOfBirth(LocalDate.of(1990, 2, 2));
//        u.addPhoto(new Photo(2L, null));
//        list.add(u);
//
//        u = new User();
//        u.setId(2L);
//        u.setName("The beauty 2");
//        u.setBio("Very beautiful");
//        u.setContact("Contact me at 641 888 888");
//        u.setDateOfBirth(LocalDate.of(1990, 2, 2));
//        u.addPhoto(new Photo(2L, null));
//        list.add(u);
        m.addAttribute("list", us.findAllMatch(getUser().getId()));
        return "match";
    }
}
