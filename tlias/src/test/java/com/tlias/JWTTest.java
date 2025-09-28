package com.tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {

    @Test
    public void generateJWT() {
        Map<String,Object> claim = new HashMap<>();
        claim.put("id",1);
        claim.put("name","shiyu");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "shiyu").addClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)).compact();
        System.out.println(jwt);
    }

    @Test
    public void parseJWT() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoic2hpeXUiLCJpZCI6MSwiZXhwIjoxNzU5MDUxODY0fQ.1wxjErEcdxTWONKQilAg14Tw_7XQnfa_2SNBeJ60kts";
        Claims claims = Jwts.parser().setSigningKey("shiyu").parseClaimsJws(token).getBody();
        System.out.println(claims);
    }
}
