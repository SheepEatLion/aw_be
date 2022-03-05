package com.mynameisjunyeong.aw_be.rest.domain.story;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class StoryRepositorySupport extends QuerydslRepositorySupport {

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public StoryRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Story.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
