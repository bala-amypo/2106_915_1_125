package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request);
        return ResponseEntity.status(201).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegisterRequest request) {
        User user = userService.findByEmail(request.getEmail());
        // Password validation omitted for brevity, integrate PasswordEncoder.matches()
        String token = jwtTokenProvider.generateToken(user.getEmail());
        return ResponseEntity.ok(token);
    }
}
