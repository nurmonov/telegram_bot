package com.uz.telegrambot.service;


import com.uz.telegrambot.entity.Roles;
import com.uz.telegrambot.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class TokenService {

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("phone", user.getPhone());
        StringJoiner sj = new StringJoiner(",");
        for (Roles role : user.getRoles()) {
            sj.add(role.getRole().toString());
        }
        claims.put("roles", sj.toString());
        return Jwts.builder()
                .signWith(signKey())
                .subject(user.getPhone())
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .compact();
    }
    public boolean isValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getUserPhone(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(signKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey signKey() {
        return Keys.hmacShaKeyFor("12345678123456781234567812345678".getBytes());
    }
}
