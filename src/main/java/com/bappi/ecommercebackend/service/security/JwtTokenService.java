package com.bappi.ecommercebackend.service.security;

import com.bappi.ecommercebackend.util.Constants;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenService {

    public String generateToken(String email){

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .subject(email)
                .claims(claims)
                .signWith(Constants.JwtConstant.SECRET_KEY)
                .issuedAt(new Date())
                .expiration(new Date())
                .compact();
    }

    public String getEmailFromToken(String token){

        return null;
    }

    public Map<String,Object> getClaimsFromToken(){

        return null;
    }

    public boolean validateToken(String token, UserDetails userDetails){

        return false;
    }

    public boolean isTokenExpired(){

        return false;
    }
}
