package com.mynameisjunyeong.aw_be.domain.story;

import com.mynameisjunyeong.aw_be.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Story Entity
 * @author junyeong
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Story extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false, length = 100)
    private String author;

}
