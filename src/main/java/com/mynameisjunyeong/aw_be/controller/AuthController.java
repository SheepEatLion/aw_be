package com.mynameisjunyeong.aw_be.controller;

import com.mynameisjunyeong.aw_be.util.AuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final KakaoAuthService kakaoAuthService;
    private final GoogleAuthService googleAuthService;
    private final AuthTokenProvider authTokenProvider;
    private final AuthService authService;

    /**
     * KAKAO
     */
    @PostMapping("/kakao")
    public ResponseEntity<AuthResponse> kakaoAuthRequest(@RequestBody AuthRequest authRequest)
        return ApiResponse.success(kakaoAuthService.login(authRequest));;
}
