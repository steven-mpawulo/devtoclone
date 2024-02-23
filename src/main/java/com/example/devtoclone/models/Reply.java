package com.example.devtoclone.models;

import com.example.devtoclone.repositories.CommentRepository;
import jakarta.persistence.*;

@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Comment comment;

}
