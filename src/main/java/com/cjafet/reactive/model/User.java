package com.cjafet.reactive.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    private static final User empty = new User();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    private String name;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Return an empty instance
    // Handles nulls without a null pointer exception being thrown inside of our app
    public static User empty() {
        return empty;
    }
}
