package com.mynameisjunyeong.aw_be.config;

import com.mynameisjunyeong.aw_be.oauth.entity.RoleType;
import com.mynameisjunyeong.aw_be.oauth.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console up
        .and()
                .authorizeRequests()    // URL 별로 권한 관리를 설정하는 옵션의 시작점, 선언 되어 있어야만 antMatchers 옵션 사용 가능.
                //.antMatchers("/**").permitAll()
                //.antMatchers("/api/v1/**").hasRole(RoleType.USER.name())  // user 권한 사람들만 열람 가능
                //.anyRequest().authenticated()   // 설정된 값 이외 나머지 URL들은 로그인한 사용자들만 허용
        .and()
                .logout()
                .logoutSuccessUrl("/")  // 로그아웃 성공시 홈으로 이동
        .and()
                .oauth2Login()  // oauth2 로그인 기능에 대한 설정 진입점
                .userInfoEndpoint() // oauth2 로그인 성공 후에 사용자 정보 가져올 때 설정 담당
                .userService(customOAuth2UserService);  // 소셜 로그인 성공시 UserService 인터페이스의 구현체를 등록한다.
    }
}
