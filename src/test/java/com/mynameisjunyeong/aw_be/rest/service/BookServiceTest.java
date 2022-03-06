package com.mynameisjunyeong.aw_be.rest.service;

import com.mynameisjunyeong.aw_be.rest.domain.book.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void create() {
        // given
        Long textLimit = 500L;
        String author = "junyeong";
        String genre = "comedy";

        // when
        Book book = bookService.create(textLimit, genre, author);

        // then
        assertEquals(book.getAuthor(), author);

    }

    @Test
    void write() {
        // given
        Long textLimit = 500L;
        String contents = "이 이야기는 천년전 영국에서 출발하여....";
        String author = "junyeong";
        String genre = "comedy";
        Book book = bookService.create(textLimit, genre, author);

        // when
        Long storyId = bookService.write(contents, book, author);

        // then
        assertNotEquals(storyId, 0L);

    }
}