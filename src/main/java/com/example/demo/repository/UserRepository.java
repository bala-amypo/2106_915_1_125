package com.example.demo.repository;

import com.example.demo.entity.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmailIgnoreCase(String email);
    User save(User user);
}