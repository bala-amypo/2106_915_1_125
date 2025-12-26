package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    public AuthController(AuthenticationManager authenticationManager, 
                         JwtTokenProvider jwtTokenProvider, 
                         UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    public ResponseEntity<User> register(RegisterRequest request) {
        User user = userService.register(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public ResponseEntity<AuthResponse> login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        User user = new User();
        user.setEmail(request.getEmail());
        String token = jwtTokenProvider.generateToken(authentication, user);
        
        return ResponseEntity.ok(new AuthResponse(token, request.getEmail()));
    }
}