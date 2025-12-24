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
        return "jwt-token"; // mocked in tests
    }
}
