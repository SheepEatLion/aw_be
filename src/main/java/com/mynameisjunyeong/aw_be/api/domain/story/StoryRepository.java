package com.mynameisjunyeong.aw_be.api.domain.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
}