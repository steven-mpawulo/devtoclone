package com.example.devtoclone.repositories;

import com.example.devtoclone.models.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
    int countFollowerByUserId(Long userId);
}
