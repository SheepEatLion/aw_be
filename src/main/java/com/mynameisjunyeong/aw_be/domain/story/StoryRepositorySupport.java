package com.mynameisjunyeong.aw_be.domain.story;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class StoryRepositorySupport extends QuerydslRepositorySupport {

    public StoryRepositorySupport(){
        super(Story.class);
    }
}
