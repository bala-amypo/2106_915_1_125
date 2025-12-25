package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;   // ✅ REQUIRED IMPORT
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return "Logged in as " + request.getUsername();
    }
}
