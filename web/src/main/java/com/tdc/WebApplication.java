package com.tdc;


import com.tdc.domain.User;
import com.tdc.domain.UserLike;
import com.tdc.repo.UserLikeRepo;
import com.tdc.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@SpringBootApplication
public class WebApplication {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {

        ApplicationContext app =SpringApplication.run(WebApplication.class, args);
        UserRepo ur = app.getBean(UserRepo.class);
        UserLikeRepo ulr = app.getBean(UserLikeRepo.class);
        User u = new User("Handsome Mohamed", "hm", "123",
                null, LocalDate.of(1986,02,02),0);
        u.setBio("Very handsome");
        u.setPhoto(1L);
        ur.save(u);

        User u2 = new User("The beauty", "tb", "123",
                null, LocalDate.of(1990,02,02),1);
        u2.setBio("Very beautiful");
        u2.setContact("Call me at 641 888 999");
        u2.setPhoto(2L);
        ur.save(u2);

        UserLike ul = new UserLike(null, u2,u, true);

        User u3 = new User("The beauty #2", "tb2", "123",
                null, LocalDate.of(1990,02,02),1);
        u3.setBio("Very beautiful");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(3L);
        ur.save(u3);

        ulr.save(ul);
    }

}
