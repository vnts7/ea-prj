package com.tdc.controller;

import com.tdc.domain.User;
import com.tdc.service.UserServiceProxy;
import com.tdc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class UserController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/photo";


    @Autowired
    private UserServiceProxy us;

    private UserValidator userValidator;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userModel", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userModel") User user, BindingResult bindingResult, @RequestParam("photo") MultipartFile file, RedirectAttributes redirectAttributes) {
//        userValidator.validate(user, bindingResult);
//        if (bindingResult.hasErrors()) {
//            System.out.println("HAS ERRORS");
//            return "/";
//        }
//        System.out.println("NO ERRORS");
        Integer newId = ThreadLocalRandom.current().nextInt(100000);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "Please select a file to upload");
            return "redirect:/register";
        }
        Path fileNameAndPath = Paths.get(uploadDirectory, newId + ".jpg");
        try {
            Files.write(fileNameAndPath, file.getBytes());
            user.setPhoto(newId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setPasswordConfirm("");
        us.save(user);

        return "redirect:/login";
    }
}
