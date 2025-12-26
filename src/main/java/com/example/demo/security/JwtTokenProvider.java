package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.example.demo.entity.User;

@Component
public class JwtTokenProvider {
    public String generateToken(Authentication authentication, User user) {
        return "jwt-token";
    }
}