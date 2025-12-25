package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists";
        }

        user.setRole("ROLE_USER");   // ✅ REQUIRED
        userRepository.save(user);

        return "User registered successfully";
    }
}
