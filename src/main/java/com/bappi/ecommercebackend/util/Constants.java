package com.bappi.ecommercebackend.util;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class Constants {

    public static class Message{
        public static final String USER_CREATE_RESPONSE_MESSAGE = "YOUR ACCOUNT SUCCESSFULLY CREATED";
    }

    public static class JwtConstant{
        public static final SecretKey SECRET_KEY= Keys.hmacShaKeyFor("b63f27727e24a4da182952b16166d584".getBytes());
        public static final String JWT_HEADER="Authorization";
    }

    public static class REGEX{
        public static final String EMAIL_REGEX = "^(?=.*[A-Za-z])(?=.*\\d).{4,20}$";
        public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d).{4,20}$";
    }
}
