package com.pathwise.backend.controller;
import com.pathwise.backend.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private String savedEmail = "admin@gmail.com";
    private String savedPassword = "1234";

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        savedEmail = user.getEmail();
        savedPassword = user.getPassword();
        return "Registered Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if (user.getEmail().equals(savedEmail) &&
            user.getPassword().equals(savedPassword)) {
            return "Login Success";
        } else {
            return "Invalid Credentials";
        }
    }
}