package com.mynameisjunyeong.aw_be.config;

import com.mynameisjunyeong.aw_be.util.AuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //private final AuthTokenProvider authTokenProvider;  // kakao

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authTokenProvider);

        http.authorizeHttpRequests().mvcMatchers("/").permitAll();
    }


}
