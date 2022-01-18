package com.mynameisjunyeong.aw_be.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateDto {

    private String genre;
    private Long textLimit;
    private String author;
    private String contents;

}
