package com.tdc.domain;


import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Column(columnDefinition = "POINT")
    private Point location;

    @Past
    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Integer gender;//0: male, 1: female

    @NotNull
    private Integer interestedIn;//-1 all, 0: male, 1: female

    @OneToMany(mappedBy = "user")
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "to")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "liker")
    private List<UserLike> likers = new ArrayList<>();

    @OneToMany(mappedBy = "likee")
    private List<UserLike> likees = new ArrayList<>();

    public User() {
    }

    public User(@NotBlank String name, @NotBlank String username, @NotBlank String password, Point location, @Past @NotNull LocalDate dateOfBirth, @NotNull Integer gender, @NotNull Integer interestedIn) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.interestedIn = interestedIn;
    }
}
