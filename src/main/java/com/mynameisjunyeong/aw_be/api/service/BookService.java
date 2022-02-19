package com.mynameisjunyeong.aw_be.api.service;

import com.mynameisjunyeong.aw_be.api.domain.post.Post;
import com.mynameisjunyeong.aw_be.api.domain.post.PostRepository;
import com.mynameisjunyeong.aw_be.api.domain.post.PostRepositorySupport;
import com.mynameisjunyeong.aw_be.api.domain.story.Story;
import com.mynameisjunyeong.aw_be.api.domain.story.StoryRepository;
import com.mynameisjunyeong.aw_be.api.domain.story.StoryRepositorySupport;
import com.mynameisjunyeong.aw_be.dto.BookCreateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final PostRepository postRepository;
    private final StoryRepository storyRepository;
    private final PostRepositorySupport postRepositorySupport;
    private final StoryRepositorySupport storyRepositorySupport;

    public void create(BookCreateDto bookCreateDto){

        log.info("Book Create Dto: " + bookCreateDto.getTextLimit());
        Post post = Post.builder()
                .author(bookCreateDto.getAuthor())
                .genre(bookCreateDto.getGenre())
                .textLimit(bookCreateDto.getTextLimit())
                .build();
        postRepository.save(post);

        Long postId = postRepositorySupport.findPostId(post.getAuthor(), post.getCreatedDate(), post.getGenre());

        Story story = Story.builder()
                .author(post.getAuthor())
                .contents(bookCreateDto.getContents())
                .postId(postId)
                .build();
        storyRepository.save(story);
    }
/*
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
*/
}
