package com.example.demo.service;

import com.example.demo.model.LocalUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JWTService {


  @Value("${jwt.algorithm.key}")
  private String algorithmKey;

  @Value("${jwt.issuer}")
  private String issuer;


  private Algorithm algorithm;

  private static final String USERNAME_KEY = "USERNAME";


  @PostConstruct
  public void postConstruct() {
    algorithm = Algorithm.HMAC256(algorithmKey);
  }


  public String getUsername(String token) {
    DecodedJWT jwt = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
    return jwt.getClaim(USERNAME_KEY).asString();
  }

}
