package com.mynameisjunyeong.aw_be.rest.domain.book;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositorySupport extends QuerydslRepositorySupport {

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public BookRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Book.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
