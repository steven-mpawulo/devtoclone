package com.example.devtoclone.controllers;

import com.example.devtoclone.exception.FailedToCreateArticleException;
import com.example.devtoclone.exception.NoArticleFoundException;
import com.example.devtoclone.exception.NoUserFoundException;
import com.example.devtoclone.models.Article;
import com.example.devtoclone.models.Comment;
import com.example.devtoclone.models.Reaction;
import com.example.devtoclone.models.User;
import com.example.devtoclone.repositories.ArticleRepository;
import com.example.devtoclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/articles")
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{articleId}")
    public Article getArticle(@PathVariable Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (article.isPresent()) {
            return article.get();
        } else {
            throw new NoArticleFoundException(HttpStatus.NOT_FOUND, "article with provided id not found");
        }
    }

    @PostMapping("/articles")
    public Article addArticle(@RequestBody Map<String, Object> jsonData) {
        int userIdInt = (int) jsonData.get("userId");
        Long userId = (long) userIdInt;
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()){
            User actualUser = user.get();
            Article article = new Article(
                    (String) jsonData.get("imageUrl"),
                    (String) jsonData.get("title"),
                    (String) jsonData.get("content"),
                    (String) jsonData.get("readTime"),
                    (boolean) jsonData.get("isBookmarked"),
                    actualUser,
                    (List) jsonData.get("comments"),
                    (List) jsonData.get("reactions")

                    );

            Article savedArticle = articleRepository.save(article);
            List<Article> oldUserArticles = actualUser.getArticles();
            oldUserArticles.add(savedArticle);
            userRepository.save(actualUser);
            return savedArticle;

        } else {
            throw new FailedToCreateArticleException(HttpStatus.FAILED_DEPENDENCY, "no user found to create article");
        }
    }

    @PutMapping("/articles/{articleId}/comment")
    public Article commentOnArticle(@PathVariable Long articleId, @RequestBody Map<String, Object> jsonData) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (article.isPresent()) {
            Article actualArticle = article.get();
            String content = (String) jsonData.get("content");
            int userIdInt = (int) jsonData.get("userId");
            Long userId = (long) userIdInt;
            Optional<User> userAddingComment = userRepository.findById(userId);
            if (userAddingComment.isPresent()) {
                User user = userAddingComment.get();
                List<Comment> articleComments = actualArticle.getComments();
                Comment comment = new Comment(user, actualArticle, content);
                articleComments.add(comment);
                List<Comment> userComments = user.getComments();
                userComments.add(comment);
                userRepository.save(user);
                return articleRepository.save(actualArticle);
            } else {
                throw new NoUserFoundException(HttpStatus.NOT_FOUND, "failed to add comment because no user with provided id is found");
            }


        } else {
            throw new NoArticleFoundException(HttpStatus.NOT_FOUND, "no article found to update");
        }
    }

    @PutMapping("/articles/{articleId}/reaction")
    public Article reactToArticle(@PathVariable Long articleId, @RequestBody Map<String, Object> jsonData) {
        Optional<Article> article = articleRepository.findById(articleId);

        if (article.isPresent()) {
            Article actualArticle = article.get();
            List<Reaction> reactions = actualArticle.getReactions();
            String content = (String) jsonData.get("content");
            Reaction reaction = new Reaction(actualArticle, content);
            reactions.add(reaction);
            return articleRepository.save(actualArticle);
        } else {
            throw new NoArticleFoundException(HttpStatus.NOT_FOUND, "failed to react on article because article with provided id not found");
        }
    }

    @PutMapping("/articles/{articleId}/bookmark")
    public Article changeBookmark(@PathVariable Long articleId){
        Optional<Article> article = articleRepository.findById(articleId);
        if (article.isPresent()) {
            Article actualArticle = article.get();
            boolean articleBookmark = actualArticle.isBookmarked();
            boolean newArticleBookmark = !articleBookmark;
            actualArticle.setBookmarked(newArticleBookmark);
            return articleRepository.save(actualArticle);
        } else {
            throw new NoArticleFoundException(HttpStatus.NOT_FOUND, "failed to update bookmark since article with provided id not found");
        }
    }
}
