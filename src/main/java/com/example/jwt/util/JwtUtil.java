package com.example.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Date;

public class JwtUtil {

    public static String createToken(String employNumber, long expireTimeMs, String key) {
        Claims claims = Jwts.claims();
        claims.put("employNumber", employNumber);
        String base64Key = Base64.encodeBase64URLSafeString(key.getBytes());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expireTimeMs))
                .signWith(SignatureAlgorithm.HS256, base64Key)
                .compact();
    }
}
