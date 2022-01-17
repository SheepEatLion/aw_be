package com.mynameisjunyeong.aw_be.domain.user;

import com.mynameisjunyeong.aw_be.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

/**
 * User Entity
 * @author junyeong
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String pw;

    @Column(length = 100, nullable = false)
    private String name;

}
