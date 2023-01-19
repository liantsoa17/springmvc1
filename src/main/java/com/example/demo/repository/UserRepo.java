package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select * from users where sexe = :type",nativeQuery = true)
    List<User> findOpposite(@Param("type") Integer type);
}
