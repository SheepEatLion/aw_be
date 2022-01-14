package com.mynameisjunyeong.aw_be.domain.post;

import com.mynameisjunyeong.aw_be.domain.BaseTimeEntity;

import javax.persistence.*;

/**
 * Post Entity
 * @author junyeong
 */

@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long textLimit;

    @Column(length = 100)
    private String author;

    @Column(length = 100)
    private String genre;
}
