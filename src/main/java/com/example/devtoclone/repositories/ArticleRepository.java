package com.example.devtoclone.repositories;

import com.example.devtoclone.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    int countAllByUserId(Long userId);

}
