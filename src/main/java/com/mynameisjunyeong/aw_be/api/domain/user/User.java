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

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @Column(name = "USER_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "USER_ID", nullable = false, unique = true)
    private String userId;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(name = "ROLE_TYPE", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column(name = "PROVIDER_TYPE", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @Column(name = "EMAIL_VERIFIED_YN", length = 1, nullable = false)
    private String emailVerifiedYn;

    @Column(name = "PROFILE_IMAGE_URL", length = 512, nullable = false)
    private String profileImageUrl;

    // create at
    // modified at

    public User(
            @NotNull @Size(max = 64) String userId, @NotNull @Size(max = 100) String username,
            @NotNull @Size(max = 512) String email, @NotNull @Size(max = 1) String emailVerifiedYn,
            @NotNull @Size(max = 512) String profileImageUrl, @NotNull ProviderType providerType,
            @NotNull RoleType roleType
    ) {
        this.userId = userId;
        this.username = username;
        this.email = email != null ? email : "NO_EMAIL";
        this.password = "NO_PASS";
        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.roleType = roleType;
    }

}
