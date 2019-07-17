package com.tdc.repo;

import com.tdc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("select distinct u from User u join u.likees l where l.liker.id=:id and l.liked = true")
//    @Query(value = "select * from User u where u.id<>:id and u.id in (select likee_id from user_like where liker_id=:id and liked=1)", nativeQuery = true)
    List<User> findAllILike(@Param("id") Long id);

    @Query("select distinct u from User u join u.likers l where l.likee.id=:id and l.liked = true")
//    @Query(value = "select * from User u where u.id<>:id and u.id in (select liker_id from user_like where likee_id=:id and liked=1)", nativeQuery = true)
    List<User> findAllLikeMe(@Param("id") Long id);

    //    @Query("select distinct u from User u join u.likers l where u.id <> :id and l.liker.id<>:id")
    @Query(value = "select * from User u where u.id<>:id and u.id not in (select likee_id from user_like where liker_id=:id)", nativeQuery = true)
    List<User> next(@Param("id") Long id);
}
