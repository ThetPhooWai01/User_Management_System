package com.example.crud.test.demo.repo;

import com.example.crud.test.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM user WHERE name LIKE %:keyword%")
    List<User> searchUser(@Param("keyword") String keyword);
}
