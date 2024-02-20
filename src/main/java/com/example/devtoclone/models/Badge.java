package com.example.devtoclone.models;

import jakarta.persistence.*;

@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }
    protected Badge() {}
    public Badge(User user) {
        this.user = user;
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
}
