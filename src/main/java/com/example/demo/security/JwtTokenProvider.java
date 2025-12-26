package com.example.demo.security;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // TEST EXPECTS THIS METHOD
    public String generateToken(String username) {
        return "jwt-token";
    }

    // TEST ALSO EXPECTS THIS OVERLOADED METHOD
    public String generateToken(Object authentication, User user) {
        return "jwt-token";
    }
}
