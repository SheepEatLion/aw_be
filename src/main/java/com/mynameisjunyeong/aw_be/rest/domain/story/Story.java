package com.mynameisjunyeong.aw_be.rest.domain.story;

import com.mynameisjunyeong.aw_be.rest.domain.BaseTimeEntity;
import com.mynameisjunyeong.aw_be.rest.domain.book.Book;
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


    /**
     * 비지니스 로직
     */

    @Builder
    public Story(Book book, String contents, String author){
        this.book = book;
        this.contents = contents;
        this.author = author;
    }
}
