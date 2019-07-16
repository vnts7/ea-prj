package com.tdc.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(unique = true)
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

    @Embedded
    private Filter filter;

    private String bio;
    private String contact;
    private Integer numNotification = 0;

    private Integer photo;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Photo> photos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "liker")
    private List<UserLike> likers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "likee")
    private List<UserLike> likees = new ArrayList<>();

    public User() {
    }

    public User(@NotBlank String name, @NotBlank String username, @NotBlank String password, Point location, @Past @NotNull LocalDate dateOfBirth, @NotNull Integer gender) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Integer getAge(){
        Period p = Period.between(dateOfBirth, LocalDate.now());
        return p.getYears();
    }

//    public Long getPhoto()
//    {
//        if(photos.size()>0)return photos.get(0).getId();
//        return 0L;
//    }
//
//    public void addPhoto(Photo p){
//        photos.add(p);
//        p.setUser(this);
//    }
}
