package com.mynameisjunyeong.aw_be.rest.service;

import com.mynameisjunyeong.aw_be.rest.domain.book.Book;
import com.mynameisjunyeong.aw_be.rest.domain.book.BookRepository;
import com.mynameisjunyeong.aw_be.rest.domain.book.BookRepositorySupport;
import com.mynameisjunyeong.aw_be.rest.domain.story.Story;
import com.mynameisjunyeong.aw_be.rest.domain.story.StoryRepository;
import com.mynameisjunyeong.aw_be.rest.domain.story.StoryRepositorySupport;
import com.mynameisjunyeong.aw_be.dto.BookCreateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final StoryRepository storyRepository;
    private final BookRepositorySupport bookRepositorySupport;
    private final StoryRepositorySupport storyRepositorySupport;

    public void create(BookCreateDto bookCreateDto){

        log.info("Book Create Dto: " + bookCreateDto.getTextLimit());
        Book post = Book.builder()
                .author(bookCreateDto.getAuthor())
                .genre(bookCreateDto.getGenre())
                .textLimit(bookCreateDto.getTextLimit())
                .build();
        bookRepository.save(post);

        Long postId = bookRepositorySupport.findPostId(post.getAuthor(), post.getCreatedDate(), post.getGenre());

        Story story = Story.builder()
                .author(post.getAuthor())
                .contents(bookCreateDto.getContents())
                .id(postId)
                .build();
        storyRepository.save(story);
    }

    public void write(){

    }

    public void read(){

    }

    public void readAll(){

    }

    public void update(){

    }

    public void delete(){

    }

}
