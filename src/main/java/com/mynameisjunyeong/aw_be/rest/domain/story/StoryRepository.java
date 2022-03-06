package com.mynameisjunyeong.aw_be.rest.domain.story;

import com.mynameisjunyeong.aw_be.rest.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findByBookOrderByCreatedDateAsc(Book book);
    Long countByBook(Book book);
}
