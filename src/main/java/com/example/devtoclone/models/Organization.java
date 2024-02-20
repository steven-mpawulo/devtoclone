package com.example.devtoclone.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "public")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
