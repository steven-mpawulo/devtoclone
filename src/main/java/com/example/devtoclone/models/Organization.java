package com.example.devtoclone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "public")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String organizationName;
    @OneToMany
    private List<User> users;

    public String getOrganizationName() {
        return organizationName;
    }

    protected Organization() {
    }

    public Organization(String organizationName, List<User> users) {
        this.organizationName = organizationName;
        this.users = users;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }




}
