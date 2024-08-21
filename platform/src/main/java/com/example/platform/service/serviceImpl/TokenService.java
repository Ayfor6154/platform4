package com.example.platform.service.serviceImpl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import com.example.platform.entity.User;
import java.util.Date;

//import lombok.Data;

//@Data
@Service
public class TokenService {

    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        System.out.println("1ID:"+user.getID());
        System.out.println("2PWd:"+user.getPassword());
        token = JWT.create().withAudience(String.valueOf(user.getID()))
                //.withIssuedAt(start)
                //.withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
