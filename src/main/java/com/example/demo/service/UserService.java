package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;

public interface UserService {

    User register(RegisterRequest request);

    // 🔥 REQUIRED FOR LOGIN TESTS
    User findByEmail(String email);
}
