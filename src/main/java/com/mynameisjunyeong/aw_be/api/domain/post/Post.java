package com.mynameisjunyeong.aw_be.api.domain.post;

import com.mynameisjunyeong.aw_be.api.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Post Entity
 * @author junyeong
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @Column(name = "post_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postSeq;

    @Column(nullable = false)
    private Long textLimit;

    @Column(length = 100)
    private String author;

    @Column(length = 100)
    private String genre;
}
