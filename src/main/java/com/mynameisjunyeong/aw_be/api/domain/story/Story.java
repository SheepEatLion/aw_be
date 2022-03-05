package com.mynameisjunyeong.aw_be.api.domain.story;

import com.mynameisjunyeong.aw_be.api.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Story Entity
 * @author junyeong
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Story extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "post_id")
    private Long postId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false, length = 100)
    private String author;

}
