package com.mynameisjunyeong.aw_be.domain.post;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PostRepositorySupport extends QuerydslRepositorySupport {

    public PostRepositorySupport(){
        super(Post.class);
    }
}
