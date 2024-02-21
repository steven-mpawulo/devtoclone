package com.example.devtoclone.controllers;

import com.example.devtoclone.models.Article;
import com.example.devtoclone.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles")
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }
}
