package com.example.devtoclone.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imageUrl;
    private Date createdOn;
    private Date updatedOn;
    private String title;
    private String content;
    private String readTime;
    private boolean isBookmarked;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Comment> comments;
}
