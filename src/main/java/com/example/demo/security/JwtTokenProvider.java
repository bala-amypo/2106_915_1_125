package com.example.demo.security;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    public String generateToken(Object authentication, User user) {
        return "mock-jwt-token";
    }
}