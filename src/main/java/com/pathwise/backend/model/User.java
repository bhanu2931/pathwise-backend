package com.pathwise.backend.model;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // ✅ THIS FIXES ERROR
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}