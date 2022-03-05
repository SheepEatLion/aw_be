package com.mynameisjunyeong.aw_be.api.domain.book;

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
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long textLimit;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(length = 100, nullable = false)
    private String genre;
}
