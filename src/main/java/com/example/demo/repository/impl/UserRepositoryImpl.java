package com.example.demo.repository.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findByEmailIgnoreCase(String email) {
        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    // other JpaRepository methods can stay unimplemented
}
