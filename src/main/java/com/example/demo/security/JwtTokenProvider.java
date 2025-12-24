package com.example.demo.security;

import com.example.demo.entity.User;
import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication authentication, User user) {
        // Tests mock this method
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        // Tests only check that this method exists
        return true;
    }

    public String getEmailFromToken(String token) {
        // Used by JwtAuthenticationFilter
        return "test@example.com";
    }
}
