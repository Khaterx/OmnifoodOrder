package com.omnifood.omnifoodorder.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.omnifood.omnifoodorder.config.Security.jwt.JwtProperties;
import com.omnifood.omnifoodorder.dto.JwtLogin;
import com.omnifood.omnifoodorder.dto.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenService {
    private AuthenticationManager authenticationManager;

    @Autowired
    public JwtTokenService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private String generateToke(Authentication authResult) {

        // Grab Principal
        UserConfiguration principal = (UserConfiguration) authResult.getPrincipal();
        System.out.println(principal.getUsername());

        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
        return token;
    }

    public String login(JwtLogin jwtLogin) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                jwtLogin.getEmail(),
                jwtLogin.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = generateToke(authentication);
        return token;
    }
}
