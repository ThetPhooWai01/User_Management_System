package com.example.crud.test.demo.repo;

import com.example.crud.test.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
