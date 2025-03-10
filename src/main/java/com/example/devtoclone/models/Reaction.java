package com.example.devtoclone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(schema = "public")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected Reaction() {
    }

    public Reaction(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Article article;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
