package com.example.devtoclone.repositories;

import com.example.devtoclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
