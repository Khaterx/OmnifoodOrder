package com.omnifood.omnifoodorder.config.Security.jwt;

import com.auth0.jwt.JWT;
import com.omnifood.omnifoodorder.deo.UserInfoRepository;
import com.omnifood.omnifoodorder.dto.UserConfiguration;
import com.omnifood.omnifoodorder.model.UserInfo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserInfoRepository userInfoRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserInfoRepository userInfoRepository) {
        super(authenticationManager);
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Read the Authorization header, where the JWT token should be.
        String header = request.getHeader(JwtProperties.HEADER_STRING);

        // Check If header does not contain, BEARER or isNULL delegate to Spring impl and exit.
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        // If the header is present, grab the user principal from the database and perform authorization.
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // continue filter execution.
        chain.doFilter(request, response);

    }

    //Bearer
    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKEN_PREFIX, "");

        if (token != null) {

            // parse the token and validate it.
            String email = JWT.require(HMAC512(JwtProperties.SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            // Search in the DB if we find the user by token subject(userName).
            // If so, then grab user details and create a spring auth token using username, password, authorities,roles.
            if (email != null) {
                UserInfo userInfo = userInfoRepository.findByEmail(email);
                UserConfiguration principal = new UserConfiguration(userInfo);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userInfo, null, principal.getAuthorities());
                return auth;
            }
            return null;
        }
        return null;
    }
}
