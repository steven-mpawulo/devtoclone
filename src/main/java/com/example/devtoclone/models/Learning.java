package com.example.devtoclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Learning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}