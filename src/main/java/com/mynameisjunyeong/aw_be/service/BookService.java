package com.mynameisjunyeong.aw_be.service;

import com.mynameisjunyeong.aw_be.domain.post.Post;
import com.mynameisjunyeong.aw_be.domain.post.PostRepository;
import com.mynameisjunyeong.aw_be.domain.post.PostRepositorySupport;
import com.mynameisjunyeong.aw_be.domain.story.Story;
import com.mynameisjunyeong.aw_be.domain.story.StoryRepository;
import com.mynameisjunyeong.aw_be.domain.story.StoryRepositorySupport;
import com.mynameisjunyeong.aw_be.dto.BookCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final PostRepository postRepository;
    private final StoryRepository storyRepository;
    private final PostRepositorySupport postRepositorySupport;
    private final StoryRepositorySupport storyRepositorySupport;

    public void create(BookCreateDto bookCreateDto){
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
