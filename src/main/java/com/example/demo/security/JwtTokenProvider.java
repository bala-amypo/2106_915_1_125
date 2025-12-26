package com.example.demo.security;

import org.springframework.security.core.Authentication;
import com.example.demo.entity.User;

public class JwtTokenProvider {
    public String generateToken(Authentication authentication, User user) {
        return "jwt-token";
    }
}