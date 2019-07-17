package com.tdc.repo;

import com.tdc.domain.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeRepo  extends JpaRepository<UserLike,Long> {

    @Query("select count(ul) from UserLike ul where ul.liked=:liked and ul.likee.id=:likee and ul.liker.id=:liker")
    Integer queryCount(Long liker, Long likee, Boolean liked);
}
