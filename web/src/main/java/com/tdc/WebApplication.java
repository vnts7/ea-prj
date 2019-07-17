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
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {

        ApplicationContext app =SpringApplication.run(WebApplication.class, args);
        UserRepo ur = app.getBean(UserRepo.class);
        UserLikeRepo ulr = app.getBean(UserLikeRepo.class);
        
 	String pass = new BCryptPasswordEncoder().encode("123");

        User u = new User("Handsome Mohamed", "hm", pass,
                null, LocalDate.of(1986,01,02),0);
        u.setBio("Very handsome");
        u.setPhoto(1);
        u.setFilter(new Filter(-1,null,18,35));
        ur.save(u);

        User u2 = new User("The beauty", "tb", pass,
                null, LocalDate.of(1990,02,02),1);
        u2.setBio("Very beautiful");
        u2.setContact("Call me at 641 888 999");
        u2.setPhoto(2);
        ur.save(u2);

        UserLike ul = new UserLike(null, u2,u, true);

        User u3 = new User("The beauty #2", "tb2", pass,
                null, LocalDate.of(1990,10,07),1);
        u3.setBio("Very hot");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(3);
        ur.save(u3);

        User u4 = new User("Natalie Jackson", "Nadia", pass,
                null, LocalDate.of(1993,05,20),1);
        u4.setBio("Very smart");
        u4.setContact("Call me at 641 888 999");
        u4.setPhoto(120);
        ur.save(u4);

        User u5 = new User("Janet Portman", "Jane", pass,
                null, LocalDate.of(1995,05,25),1);
        u5.setBio("Very good chef");
        u5.setContact("Call me at 641 888 999");
        u5.setPhoto(121);
        ur.save(u5);

        User u6 = new User("Susan Lee", "Suzz", pass,
                null, LocalDate.of(1988,11,26),1);
        u6.setBio("Love traveling with strangers");
        u6.setContact("Call me at 641 888 999");
        u6.setPhoto(122);
        ur.save(u6);

        User u7 = new User("Nicole Kim", "Kim", pass,
                null, LocalDate.of(1989,12,31),1);
        u7.setBio("Can chat 24/7 with It guys");
        u7.setContact("Call me at 641 888 999");
        u7.setPhoto(124);
        ur.save(u7);

        User u8 = new User("Gabreil Marcel", "Sweetpie", pass,
                null, LocalDate.of(1990,1,11),1);
        u8.setBio("Swimming master");
        u8.setContact("Call me at 641 888 999");
        u8.setPhoto(125);
        ur.save(u8);

        User u9 = new User("Dorotha Samuel", "boobsy", pass,
                null, LocalDate.of(1992,05,10),1);
        u9.setBio("Miss pageant");
        u9.setContact("Call me at 641 888 999");
        u9.setPhoto(126);
        ur.save(u9);

        User u10 = new User("Celine Gomez", "blink", pass,
                null, LocalDate.of(1993,04,07),1);
        u10.setBio("Beatuful blinker");
        u10.setContact("Call me at 641 888 999");
        u10.setPhoto(127);
        ur.save(u10);

        User u11 = new User("Sarah Parker", "Sarah", pass,
                null, LocalDate.of(1994,04,25),1);
        u11.setBio("Lovely fasionista");
        u11.setContact("Call me at 641 888 999");
        u11.setPhoto(128);
        ur.save(u11);

        User u12 = new User("Tyler Swift", "crownqueen", pass,
                null, LocalDate.of(1985,03,24),1);
        u12.setBio("Queen of the dancing club. Call me if you love dancing");
        u12.setContact("Call me at 641 888 999");
        u12.setPhoto(129);
        ur.save(u12);

        User u13 = new User("Michel Phelps", "dolphin", pass,
                null, LocalDate.of(1990,11,10),0);
        u13.setBio("Handsome swimmer");
        u13.setContact("Call me at 641 888 999");
        u13.setPhoto(131);
        ur.save(u13);

        User u14 = new User("Antony Zarr", "actor", pass,
                null, LocalDate.of(1982,04,06),0);
        u14.setBio("Hot math teacher");
        u14.setContact("Call me at 641 888 999");
        u14.setPhoto(134);
        ur.save(u14);

        User u15 = new User("Allan", "barber", pass,
                null, LocalDate.of(1990,04,03),0);
        u15.setBio("Full time barber and half time musician");
        u15.setContact("Call me at 641 888 999");
        u15.setPhoto(135);
        ur.save(u15);

        User u16 = new User("Christian Ronaldo", "footballer", pass,
                null, LocalDate.of(1985,03,24),0);
        u16.setBio("Very smart developer and love to play the footbal every other weekends");
        u16.setContact("Call me at 641 888 999");
        u16.setPhoto(136);
        ur.save(u16);

        User u17 = new User("John Park", "princePark", pass,
                null, LocalDate.of(1995,12,01),0);
        u17.setBio("Full time student at MUM");
        u17.setContact("Call me at 641 888 999");
        u17.setPhoto(137);
        ur.save(u17);

        User u18 = new User("Jackie Chan", "lovelybird", pass,
                null, LocalDate.of(1993,05,13),0);
        u18.setBio("Only accept hot girls calls");
        u18.setContact("Call me at 641 888 999");
        u18.setPhoto(138);
        ur.save(u18);

        User u19 = new User("Samuel Lee", "lee", pass,
                null, LocalDate.of(1980,01,01),0);
        u19.setBio("Hot Wall Street wolf");
        u19.setContact("Call me at 641 888 999");
        u19.setPhoto(139);
        ur.save(u19);

        User u20 = new User("Kyle Kuzma", "ballOwner", pass,
                null, LocalDate.of(1995,07,30),0);
        u20.setBio("Basketball player and full time model at the Coca Cola");
        u20.setContact("Call me at 641 888 999");
        u20.setPhoto(140);
        ur.save(u20);

        User u21 = new User("Dreamy Guy", "dreamy", pass,
                null, LocalDate.of(1993,05,13),0);
        u21.setBio("OMG look at him, right?");
        u21.setContact("Call me at 641 888 999");
        u21.setPhoto(141);
        ur.save(u21);

        ulr.save(ul);

    }

}
