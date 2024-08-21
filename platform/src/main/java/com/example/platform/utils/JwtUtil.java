package com.example.platform.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.platform.entity.User;

public class JwtUtil {

    public static String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getID().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}