package com.example.funovahue.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.stream.Collectors;

public class GenerateToken {
    public Algorithm getAlgorithm(){
        return  Algorithm.HMAC256("babySecurity".getBytes());
    }
    public String generateAccessToken(User user, HttpServletRequest request,Algorithm algorithm){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+60*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }
    public String generateRefreshToken(User user, HttpServletRequest request,Algorithm algorithm){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+90 * 24 * 60 * 60 *1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
    }
    public DecodedJWT getDecodeJWT(String authorizationHeader){
        String token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = getAlgorithm();
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }
}
