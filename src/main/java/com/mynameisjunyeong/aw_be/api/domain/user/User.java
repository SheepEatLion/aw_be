package com.mynameisjunyeong.aw_be.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mynameisjunyeong.aw_be.api.domain.BaseTimeEntity;
import com.mynameisjunyeong.aw_be.oauth.entity.ProviderType;
import com.mynameisjunyeong.aw_be.oauth.entity.RoleType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User Entity
 * @author junyeong
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @Column(name = "USER_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "ROLE_TYPE", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column(length = 512)
    private String picture;

    // create at
    // modified at

    @Builder
    public User(String name, String email, String picture, RoleType roleType) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.roleType = roleType;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.roleType.getKey();
    }

}
