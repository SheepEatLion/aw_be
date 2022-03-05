package com.mynameisjunyeong.aw_be.api.domain.book;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.mynameisjunyeong.aw_be.api.domain.book.QBook.book;

@Repository
public class BookRepositorySupport extends QuerydslRepositorySupport {

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public BookRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Book.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Long findPostId(String author, LocalDateTime createdDate, String genre){
        return jpaQueryFactory
                .select(book.id)
                .from(book)
                .where(
                        book.author.eq(author),
                        book.createdDate.eq(createdDate),
                        book.genre.eq(genre)
                )
                .fetchOne();
    }
}
