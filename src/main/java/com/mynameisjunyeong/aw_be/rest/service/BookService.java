package com.mynameisjunyeong.aw_be.rest.service;

import com.mynameisjunyeong.aw_be.dto.ReadBookRes;
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

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
    public Book create(Long textLimit, String genre, String author, String title, Long totalLimit){
        Book savedBook = null;

        try {
            Book book = Book.builder().textLimit(textLimit).author(author).genre(genre).title(title).totalLimit(totalLimit).build();
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
            Story story = Story.builder().book(book).author(author).contents(contents).storyLength((long) contents.length()).build();
            Story savedStory = storyRepository.save(story);
            saveStoryId = savedStory.getId();
            book.addStory(savedStory);

        } catch (Exception e) {
            LogUtil.errorLog(e);
        }
        return saveStoryId;
    }

    // 단일 조회
    public ReadBookRes read(Long bookId){
        // 책 제목, 참여인원, 장르, 글자 수 제한, 각각 스토리들
        ReadBookRes readBookRes = new ReadBookRes();
        try {
            Optional<Book> book = bookRepository.findById(bookId);
            if(book.isPresent()){
                List<Story> stories = storyRepository.findByBookOrderByCreatedDateAsc(book.get());
                Long countStory = storyRepository.countByBook(book.get());  // 그냥 stories 에 length 구해도 될듯..?

                readBookRes.setTitle(book.get().getTitle());
                readBookRes.setGenre(book.get().getGenre());
                readBookRes.setTextLimit(book.get().getTextLimit());
                readBookRes.setParticipate(countStory);
                readBookRes.setStories(stories);

            }
        } catch (Exception e) {
            LogUtil.errorLog(e);
        }
        return readBookRes;

    }

    // 리스트 조회
    public void readAll(){

    }

    public void update(){

    }

    public void delete(){

    }

}
