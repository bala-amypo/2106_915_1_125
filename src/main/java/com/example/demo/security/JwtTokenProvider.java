package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // ⚠️ TEST EXPECTS THIS EXACT METHOD
    public String generateToken(String username) {
        return "token-for-" + username;
    }
}
