package com.example.demo.service.impl;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {}
}