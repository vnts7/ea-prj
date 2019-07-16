package com.tdc;


import com.tdc.domain.User;
import com.tdc.domain.UserLike;
import com.tdc.repo.UserLikeRepo;
import com.tdc.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {

        ApplicationContext app =SpringApplication.run(WebApplication.class, args);
        UserRepo ur = app.getBean(UserRepo.class);
        UserLikeRepo ulr = app.getBean(UserLikeRepo.class);
        User u = new User("Handsome Mohamed", "hm", "123",
                null, LocalDate.of(1986,01,02),0);
        u.setBio("Very handsome");
        u.setPhoto(1);
        ur.save(u);

        User u2 = new User("The beauty", "tb", "123",
                null, LocalDate.of(1990,02,02),1);
        u2.setBio("Very beautiful");
        u2.setContact("Call me at 641 888 999");
        u2.setPhoto(2);
        ur.save(u2);

        UserLike ul = new UserLike(null, u2,u, true);

        User u3 = new User("The beauty #2", "tb2", "123",
                null, LocalDate.of(1990,10,07),1);
        u3.setBio("Very hot");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(3);
        ur.save(u3);

        User u4 = new User("Natalie Jackson", "Nadia", "123",
                null, LocalDate.of(1993,05,20),1);
        u3.setBio("Very smart");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(120);
        ur.save(u4);

        User u5 = new User("Janet Portman", "Jane", "123",
                null, LocalDate.of(1995,05,25),1);
        u3.setBio("Very good chef");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(121);
        ur.save(u5);

        User u6 = new User("Susan Lee", "Suzz", "123",
                null, LocalDate.of(1988,11,26),1);
        u3.setBio("Love traveling with strangers");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(122);
        ur.save(u6);

        User u7 = new User("Nicole Kim", "Kim", "123",
                null, LocalDate.of(1989,12,31),1);
        u3.setBio("Can chat 24/7 with It guys");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(124);
        ur.save(u7);

        User u8 = new User("Gabreil Marcel", "Sweetpie", "123",
                null, LocalDate.of(1990,1,11),1);
        u3.setBio("Swimming master");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(125);
        ur.save(u8);

        User u9 = new User("Dorotha Samuel", "boobsy", "123",
                null, LocalDate.of(1992,05,10),1);
        u3.setBio("Miss pageant");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(126);
        ur.save(u9);

        User u10 = new User("Celine Gomez", "blink", "123",
                null, LocalDate.of(1993,04,07),1);
        u3.setBio("Beatuful blinker");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(127);
        ur.save(u10);

        User u11 = new User("Sarah Parker", "Sarah", "123",
                null, LocalDate.of(1994,04,25),1);
        u3.setBio("Lovely fasionista");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(128);
        ur.save(u11);

        User u12 = new User("Tyler Swift", "crownqueen", "123",
                null, LocalDate.of(1985,03,24),1);
        u3.setBio("Queen of the dancing club. Call me if you love dancing");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(129);
        ur.save(u12);

        User u13 = new User("Michel Phelps", "dolphin", "123",
                null, LocalDate.of(1990,11,10),0);
        u3.setBio("Handsome swimmer");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(131);
        ur.save(u13);

        User u14 = new User("Antony Zarr", "actor", "123",
                null, LocalDate.of(1982,04,06),0);
        u3.setBio("Hot math teacher");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(134);
        ur.save(u14);

        User u15 = new User("Allan", "barber", "123",
                null, LocalDate.of(1990,04,03),0);
        u3.setBio("Full time barber and half time musician");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(135);
        ur.save(u15);

        User u16 = new User("Christian Ronaldo", "footballer", "123",
                null, LocalDate.of(1985,03,24),1);
        u3.setBio("Very smart developer and love to play the footbal every other weekends");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(136);
        ur.save(u16);

        User u17 = new User("John Park", "princePark", "123",
                null, LocalDate.of(1995,12,01),0);
        u3.setBio("Full time student at MUM");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(137);
        ur.save(u17);

        User u18 = new User("Jackie Chan", "lovelybird", "123",
                null, LocalDate.of(1993,05,13),0);
        u3.setBio("Only accept hot girls calls");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(138);
        ur.save(u18);

        User u19 = new User("Samuel Lee", "lee", "123",
                null, LocalDate.of(1980,01,01),0);
        u3.setBio("Hot Wall Street wolf");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(139);
        ur.save(u19);

        User u20 = new User("Kyle Kuzma", "ballOwner", "123",
                null, LocalDate.of(1995,07,30),0);
        u3.setBio("Basketball player and full time model at the Coca Cola");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(140);
        ur.save(u20);

        User u21 = new User("Dreamy Guy", "dreamy", "123",
                null, LocalDate.of(1993,05,13),0);
        u3.setBio("OMG look at him, right?");
        u3.setContact("Call me at 641 888 999");
        u3.setPhoto(141);
        ur.save(u21);

        ulr.save(ul);
    }

}
