package com.mynameisjunyeong.aw_be.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BookCreateDto {

    private String genre;
    private Long textLimit;
    private String author;
    private String contents;

}
