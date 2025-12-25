package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String email, String password) {

        // check if user already exists
        userRepository.findByEmailIgnoreCase(email)
                .ifPresent(u -> {
                    throw new RuntimeException("Email already exists");
                });

        User user = new User();
        user.setEmail(email);        // ✅ FIXED
        user.setPassword(password);

        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email) // ✅ FIXED
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
