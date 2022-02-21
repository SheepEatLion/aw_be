package com.mynameisjunyeong.aw_be.api.service;

import com.mynameisjunyeong.aw_be.api.domain.user.User;
import com.mynameisjunyeong.aw_be.api.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }
}
