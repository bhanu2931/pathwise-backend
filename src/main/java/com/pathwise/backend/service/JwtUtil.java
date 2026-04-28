package com.pathwise.backend.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey"; // 32+ chars
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // 🔐 GENERATE TOKEN
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔥 ADD THIS (MISSING METHOD)
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // 🔥 HELPER METHOD
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 🔥 VALIDATE TOKEN
    public boolean validateToken(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}