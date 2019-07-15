package com.tdc.repo;

import com.tdc.domain.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeRepo  extends JpaRepository<UserLike,Long> {
}
