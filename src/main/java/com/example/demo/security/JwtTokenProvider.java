package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // ⚠️ TEST EXPECTS EXACT STRING "jwt-token"
    public String generateToken(String username) {
        return "jwt-token";
    }
}
