package com.mynameisjunyeong.aw_be.controller;

import com.mynameisjunyeong.aw_be.dto.BookCreateDto;
import com.mynameisjunyeong.aw_be.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/book/v1")
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody BookCreateDto bookCreateDto){
        try {
            bookService.create(bookCreateDto);
        } catch (ServiceException se){
            log.error(se.getMessage());
            return new ResponseEntity("비즈니스 로직 에러", HttpStatus.OK);
        }

        return new ResponseEntity("성공적으로 글을 작성했습니다.", HttpStatus.OK);
    }

}
