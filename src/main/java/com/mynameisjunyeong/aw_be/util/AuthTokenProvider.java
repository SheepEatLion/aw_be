package com.mynameisjunyeong.aw_be.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class AuthTokenProvider {

    //@Value("${app.auth.tokenExpiry}")
    private String expiry;

    //private final Key key;
    private static final String AUTHORITIES_KEY = "role";

}
