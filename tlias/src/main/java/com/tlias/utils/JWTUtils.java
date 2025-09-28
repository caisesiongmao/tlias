package com.tlias.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtils {

    private static final String SECRET_KEY = "shiyu";

    private static final Long EXPIRE_TIME_MILL = 3600000L;

    public static String generateJWT(Map<String, Object> claims){
        return Jwts.builder().signWith(SignatureAlgorithm.HS256,SECRET_KEY).
                addClaims(claims).setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME_MILL)).compact();
    }

    public static Claims parseJWT(String jwt){
        return Jwts.parser().setSigningKey("shiyu").parseClaimsJws(jwt).getBody();
    }
}
