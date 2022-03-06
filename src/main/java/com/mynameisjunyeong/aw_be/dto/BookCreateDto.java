package com.mynameisjunyeong.aw_be.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateDto {

    private String genre;       // book entity 의 genre 컬럼
    private Long textLimit;     // book entity 의 textLimit 컬럼
    private String author;      // book entity 의 author 컬럼 + story entity 의 author 컬럼
    private String contents;    // story entity 의 contents 컬럼

}
