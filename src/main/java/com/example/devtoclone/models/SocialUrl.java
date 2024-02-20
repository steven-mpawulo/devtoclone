package com.example.devtoclone.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "public")
public class SocialUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected SocialUrl() {
    }

    public SocialUrl(User user, String content) {
        this.user = user;
        this.content = content;
    }

    @ManyToOne
    private User user;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
