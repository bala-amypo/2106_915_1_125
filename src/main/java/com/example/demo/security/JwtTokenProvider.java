package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

   
       private static final SecretKey SECRET_KEY =
                   Keys.hmacShaKeyFor("my-super-secret-key-my-super-secret-key".getBytes());

                       private static final long EXPIRATION_MS = 1000 * 60 * 60; 

                           public String generateToken(String email, User user) {

                                   return Jwts.builder()
                                                   .setSubject(email)
                                                                   .claim("role", user.getRole())
                                                                                   .claim("userId", user.getId())
                                                                                                   .setIssuedAt(new Date())
                                                                                                                   .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                                                                                                                                   .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                                                                                                                                                   .compact();
                                                                                                                                                       }
                                                                                                                                                       }
                                                                                                                                                       