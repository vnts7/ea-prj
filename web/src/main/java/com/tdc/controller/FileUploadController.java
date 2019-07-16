package com.tdc.controller;

import com.tdc.domain.Photo;
import com.tdc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.security.Principal;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
    String msg= "";
    @PostMapping("/upload")
    public String upload(Model model, Principal p, @RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) {
        StringBuilder fileNames = new StringBuilder();
        List<Photo> photos = new ArrayList<Photo>();
        if(files.length == 0) {
            redirectAttributes.addFlashAttribute("msg", "Please select a file to upload");
            return "redirect:/";
        }
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, p.getName() + "-" + file.getOriginalFilename());
            fileNames.append(p.getName() + " " +file.getOriginalFilename()+" ");

            try {
                Files.write(fileNameAndPath, file.getBytes());


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(fileNames);
        redirectAttributes.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
        return "redirect:/status";
    }

    //https://www.javalobby.org//articles/ultimate-image/#11 - image resizing

    @GetMapping("/status")
    public String uploadStatus(Model model) {
        if(!model.containsAttribute("msg")) {
            model.addAttribute("msg", "SUCCEEED");
        }
        return "status";
    }
}