package com.tdc.repo;

import com.tdc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

    @Query("select distinct u from User u join u.likers l where u.id=:id and l.liked = true")
    List<User> findAllILike(@Param("id") Long id);

    @Query("select distinct u from User u join u.likees l where u.id=:id and l.liked = true")
    List<User> findAllLikeMe(@Param("id") Long id);

    @Query("select distinct u from User u join u.likers l where u.id <> :id")
    List<User> next(@Param("id") Long id);
}
