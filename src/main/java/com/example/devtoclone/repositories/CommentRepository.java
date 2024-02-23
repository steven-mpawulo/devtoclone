package com.example.devtoclone.repositories;

import com.example.devtoclone.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticle_IdOrderByCreatedOnDesc(Long articleId);
    int countCommentByUserId(Long userId);
}
