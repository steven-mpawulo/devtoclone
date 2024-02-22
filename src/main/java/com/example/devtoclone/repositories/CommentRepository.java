package com.example.devtoclone.repositories;

import com.example.devtoclone.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticle_IdOrderByCreatedOnDesc(Long articleId);
}
