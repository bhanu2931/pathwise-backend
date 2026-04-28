package com.pathwise.backend.controller;

import com.pathwise.backend.model.User;
import com.pathwise.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    /* ================= REGISTER ================= */

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        Map<String, Object> res = new HashMap<>();

        try {
            // check if user exists
            if (repo.findByEmail(user.getEmail()).isPresent()) {
                res.put("message", "User already exists");
                return ResponseEntity.badRequest().body(res);
            }

            // save user
            repo.save(user);

            res.put("message", "Registered successfully");
            return ResponseEntity.ok(res);

        } catch (Exception e) {
            e.printStackTrace();
            res.put("message", "Server error: " + e.getMessage());
            return ResponseEntity.status(500).body(res);
        }
    }

    /* ================= LOGIN ================= */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {

        Map<String, Object> res = new HashMap<>();

        try {
            // find user
            User user = repo.findByEmail(request.getEmail()).orElse(null);

            if (user == null) {
                res.put("message", "User not found");
                return ResponseEntity.status(401).body(res);
            }

            // check password
            if (!user.getPassword().equals(request.getPassword())) {
                res.put("message", "Invalid password");
                return ResponseEntity.status(401).body(res);
            }

            // ✅ SUCCESS RESPONSE
            res.put("name", user.getName());
            res.put("email", user.getEmail());
            res.put("token", "demo-token"); // you can replace with JWT later

            return ResponseEntity.ok(res);

        } catch (Exception e) {
            e.printStackTrace(); // 🔥 prints exact error in console
            res.put("message", "Server error: " + e.getMessage());
            return ResponseEntity.status(500).body(res);
        }
    }

    /* ================= GET USERS ================= */

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(repo.findAll());
    }
}