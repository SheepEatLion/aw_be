package com.mynameisjunyeong.aw_be.api.domain.post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.mynameisjunyeong.aw_be.domain.post.QPost.post;

@Repository
public class PostRepositorySupport extends QuerydslRepositorySupport {

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public PostRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Post.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Long findPostId(String author, LocalDateTime createdDate, String genre){
        return jpaQueryFactory
                .select(post.id)
                .from(post)
                .where(
                        post.author.eq(author),
                        post.createdDate.eq(createdDate),
                        post.genre.eq(genre)
                )
                .fetchOne();
    }
}
