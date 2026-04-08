package com.pathwise.backend.controller;

import com.pathwise.backend.model.User;
import com.pathwise.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    /* ================= REGISTER ================= */

    @PostMapping("/register")
    public Object register(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        Map<String, Object> response = new HashMap<>();

        if (repo.findByEmail(email).isPresent()) {
            response.put("message", "User already exists");
            return response;
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        repo.save(user);

        response.put("message", "User registered successfully");
        return response;
    }

    /* ================= LOGIN ================= */

    @PostMapping("/login")
    public Object login(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        Map<String, Object> response = new HashMap<>();

        User user = repo.findByEmail(email).orElse(null);

        if (user == null) {
            response.put("message", "User not found");
            return response;
        }

        if (!user.getPassword().equals(password)) {
            response.put("message", "Invalid password");
            return response;
        }

        // ✅ SUCCESS LOGIN
        response.put("token", "token_" + email);
        response.put("email", email);

        return response;
    }

    /* ================= GET ALL USERS (POSTMAN) ================= */

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}