package com.mynameisjunyeong.aw_be.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadBooksRes {
    private Long id;    // book id
    private String title;
    private String genre;
    private String contents;
    private Long participate;
    private Long totalLimit;
}
