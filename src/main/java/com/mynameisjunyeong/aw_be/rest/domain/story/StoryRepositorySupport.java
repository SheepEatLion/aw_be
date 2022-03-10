package com.mynameisjunyeong.aw_be.rest.domain.story;

import com.mynameisjunyeong.aw_be.dto.ReadBooksRes;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.mynameisjunyeong.aw_be.rest.domain.book.QBook.book;
import static com.mynameisjunyeong.aw_be.rest.domain.story.QStory.story;

@Repository
public class StoryRepositorySupport extends QuerydslRepositorySupport {

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public StoryRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Story.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<ReadBooksRes> findIdAndTitleAndContentsAndParticipateAndTotalLimitAndGenre(){
        return jpaQueryFactory
                .select(Projections.fields(ReadBooksRes.class,
                        book.id,
                        book.title,
                        book.genre,
                        story.contents,
                        book.participate,
                        book.totalLimit
                ))
                .from(story)
                .join(story.book, book)
                .where(story.book.in(
                        JPAExpressions.selectFrom(book).orderBy(book.createdDate.desc())
                ))
                .groupBy(story.book)
                .orderBy(story.createdDate.asc())
                .limit(10)
                .fetch();
    }
}
