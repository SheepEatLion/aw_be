package com.mynameisjunyeong.aw_be.api.domain.story;

import com.mynameisjunyeong.aw_be.api.domain.BaseTimeEntity;
import com.mynameisjunyeong.aw_be.api.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  책 한권이 여러 스토리를 갖는 구조
 *  Book 1 : N Story
 *
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false, length = 100)
    private String author;

}
