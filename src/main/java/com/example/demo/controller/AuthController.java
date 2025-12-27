package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;

public class AuthController {
    public AuthController(AuthenticationManager authenticationManager, 
                         Object jwtTokenProvider, 
                         UserService userService) {}
}