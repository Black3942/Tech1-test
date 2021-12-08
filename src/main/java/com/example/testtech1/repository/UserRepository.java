package com.example.testtech1.repository;

import com.example.testtech1.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAgeGreaterThan(int age);

    @Query("from User u left join fetch u.articles a where a.color = :color")
    List<User> findByArticlesIsContaining(String color);

    //@Query("from User u left join fetch u.articles a group by u.id, a.id having count(a.id) > 3")
    //List<User> findByArticlesGreaterThan();
}
