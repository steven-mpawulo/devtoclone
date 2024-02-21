package com.example.devtoclone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(schema = "public")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected Comment() {}

    public Comment(User user, Article article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Article article;
    @Column(nullable = false)
    private String content;

}
