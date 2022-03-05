package com.mynameisjunyeong.aw_be.rest.domain.book;

import com.mynameisjunyeong.aw_be.rest.domain.BaseTimeEntity;
import com.mynameisjunyeong.aw_be.rest.domain.story.Story;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  책 한권이 여러 스토리를 갖는 구조
 *   Book 1 : N Story
 *
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

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Story> bookStory = new ArrayList<>();
}
