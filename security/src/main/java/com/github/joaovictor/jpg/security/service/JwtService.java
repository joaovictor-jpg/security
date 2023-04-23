package com.github.joaovictor.jpg.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private static final String SECURITY_KEY = "404E635266556A576E5A7234753778214125442A472D4B6150645367566B5970";

    public String extractUserName(String jwt) {
        return null;
    }

    private Claims claims (String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSecurityKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private Key getSecurityKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECURITY_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
