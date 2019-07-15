package com.tdc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Filter {
    private Integer interestedIn;//-1 all, 0: male, 1: female
    private Integer radius;//km
    private Integer ageFrom;
    private Integer ageTo;
}
