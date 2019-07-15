package com.tdc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class UserLike implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "liker_id")
    private User liker;

    @Id
    @ManyToOne
    @JoinColumn(name = "likee_id")
    private User likee;

    @NotNull
    private Boolean liked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLike like = (UserLike) o;

        if (liker != null ? !liker.getId().equals(like.liker.getId()) : like.liker != null) return false;
        if (likee != null ? !likee.getId().equals(like.likee.getId()) : like.likee != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = liker != null ? liker.hashCode() : 0;
        result = 31 * result + (likee != null ? likee.hashCode() : 0);
        return result;
    }
}
