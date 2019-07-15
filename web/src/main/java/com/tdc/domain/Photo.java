package com.tdc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photo {
    @Id
    private Long id;

    @ManyToOne
    private User user;
}
