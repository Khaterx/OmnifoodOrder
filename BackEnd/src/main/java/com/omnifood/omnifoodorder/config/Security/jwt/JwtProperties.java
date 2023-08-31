package com.omnifood.omnifoodorder.config.Security.jwt;

public class JwtProperties {
    public static final String SECRET = "Bow-Bow💥"; //
    public static final int EXPIRATION_TIME = 864_000_000; //10 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
