package com.example.devtoclone.models;

import com.example.devtoclone.repositories.CommentRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Reply(User user, Comment comment, String content) {
        this.user = user;
        this.comment = comment;
        this.content = content;
    }

    public Reply() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Comment comment;

    @Column(nullable = false)
    private String content;

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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
