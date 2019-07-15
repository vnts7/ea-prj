package com.tdc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String content;

    @ManyToOne
    private User from;
    @ManyToOne
    private User to;
}
