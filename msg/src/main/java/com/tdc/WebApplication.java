package com.tdc;


import com.tdc.domain.Filter;
import com.tdc.domain.User;
import com.tdc.domain.UserLike;
import com.tdc.repo.UserLikeRepo;
import com.tdc.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {

        ApplicationContext app =SpringApplication.run(WebApplication.class, args);

    }

}
