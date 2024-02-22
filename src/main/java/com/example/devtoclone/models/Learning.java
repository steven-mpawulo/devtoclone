package com.example.devtoclone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(schema = "public")
public class Learning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    protected Learning() {
    }

    public Learning(User user, String content) {
        this.user = user;
        this.content = content;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    @Column(
            nullable = false,
            unique = true)
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
