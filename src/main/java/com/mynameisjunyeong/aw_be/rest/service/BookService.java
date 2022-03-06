package com.mynameisjunyeong.aw_be.rest.service;

import com.mynameisjunyeong.aw_be.rest.domain.book.Book;
import com.mynameisjunyeong.aw_be.rest.domain.book.BookRepository;
import com.mynameisjunyeong.aw_be.rest.domain.book.BookRepositorySupport;
import com.mynameisjunyeong.aw_be.rest.domain.story.Story;
import com.mynameisjunyeong.aw_be.rest.domain.story.StoryRepository;
import com.mynameisjunyeong.aw_be.rest.domain.story.StoryRepositorySupport;
import com.mynameisjunyeong.aw_be.dto.BookCreateDto;
import com.mynameisjunyeong.aw_be.util.CommonResponse;
import com.mynameisjunyeong.aw_be.util.LogUtil;
import com.mynameisjunyeong.aw_be.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final StoryRepository storyRepository;
    private final BookRepositorySupport bookRepositorySupport;
    private final StoryRepositorySupport storyRepositorySupport;

    @Transactional
    public Book create(Long textLimit, String genre, String author){
        Book savedBook = null;

        try {
            Book book = Book.builder().textLimit(textLimit).author(author).genre(genre).build();
            savedBook = bookRepository.save(book);
        } catch (Exception e) {
            LogUtil.errorLog(e);
        }

        return savedBook;
    }

    @Transactional
    public Long write(String contents, Book book, String author){
        Long saveStoryId = 0L;
        try {
            Story story = Story.builder().book(book).author(author).contents(contents).build();
            Story savedStory = storyRepository.save(story);
            saveStoryId = savedStory.getId();
            book.addStory(savedStory);

        } catch (Exception e) {
            LogUtil.errorLog(e);
        }
        return saveStoryId;
    }

/*    public void read(){

    }

    public void readAll(){

    }

    public void update(){

    }

    public void delete(){

    }*/

}
