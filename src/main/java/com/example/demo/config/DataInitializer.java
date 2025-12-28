package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner insertDefaultUser(UserRepository userRepository,
                                        PasswordEncoder passwordEncoder) {

        return args -> {
            if (userRepository.findByEmailIgnoreCase("demo@gmail.com").isEmpty()) {

                User user = new User();
                user.setEmail("demo@gmail.com");
                user.setPassword(passwordEncoder.encode("demo123"));
                user.setRole("ROLE_USER");
                user.setActive(true);

                userRepository.save(user);
            }
        };
    }
}
