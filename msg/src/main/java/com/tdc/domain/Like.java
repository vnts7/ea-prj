package com.tdc.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Like {
    public Long liker;
    public Long likee;
    public Boolean liked;
}
