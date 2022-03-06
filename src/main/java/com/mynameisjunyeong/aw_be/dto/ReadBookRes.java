package com.mynameisjunyeong.aw_be.dto;

import com.mynameisjunyeong.aw_be.rest.domain.story.Story;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadBookRes {
    private String title;
    private String genre;
    private Long participate;
    private Long textLimit;
    private List<Story> stories;
}
