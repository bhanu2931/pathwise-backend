package com.pathwise.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pathwise.backend.model.User;
import com.pathwise.backend.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existing = repo.findByEmail(user.getEmail());

        if (existing != null) {
            return "User already exists";
        }

        repo.save(user);
        return "Registered Successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existing = repo.findByEmail(user.getEmail());

        if (existing != null && existing.getPassword().equals(user.getPassword())) {
            return "Login Success";
        } else {
            return "Invalid Credentials";
        }
    }

    // ADMIN: GET ALL USERS
    @GetMapping("/users")
    public List<User> getUsers() {
        return repo.findAll();
    }
}