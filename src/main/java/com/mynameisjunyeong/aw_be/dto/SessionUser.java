package com.mynameisjunyeong.aw_be.dto;

import com.mynameisjunyeong.aw_be.api.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 직렬화 세션 DTO
 */

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
