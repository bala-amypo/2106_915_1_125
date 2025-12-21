package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;

public interface UserService {

    User saveUser(User user);

    User getUserByEmail(String email);

    List<User> getAllUsers();
}
