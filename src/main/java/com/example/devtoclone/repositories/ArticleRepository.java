package com.example.devtoclone.repositories;

import com.example.devtoclone.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
