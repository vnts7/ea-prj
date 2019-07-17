package com.tdc.controller;

import com.tdc.domain.User;
import com.tdc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userModel", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userModel") User user, BindingResult bindingResult, @RequestParam("photo") MultipartFile[] files, RedirectAttributes redirectAttributes) {
//        userValidator.validate(user, bindingResult);
        Long newId = ThreadLocalRandom.current().nextLong(100000);
        Long picId =Long.parseLong(newId + "" + 0);
//        StringBuilder fileNames = new StringBuilder();
        if(files.length == 0) {
            redirectAttributes.addFlashAttribute("msg", "Please select a file to upload");
            return "redirect:/register";
        }
        for (MultipartFile file : files) {
//            String extension = file.getContentType().split("/")[1];
            picId++;
            Path fileNameAndPath = Paths.get(uploadDirectory, picId+".jpg");
            try {
                Files.write(fileNameAndPath, file.getBytes());
                user.setPhoto(newId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        if (bindingResult.hasErrors()) {
//            System.out.println("HAS ERRORS");
//            return "/";
//        }
        user.setId(newId);

        userService.save(user);
//
//        loginService.login(user.getUsername(), user.getPassword());
//
        return "redirect:/";
    }
}
