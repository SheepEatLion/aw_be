package com.mynameisjunyeong.aw_be.rest.restController;

import com.mynameisjunyeong.aw_be.dto.BookCreateDto;
import com.mynameisjunyeong.aw_be.dto.ReadBookRes;
import com.mynameisjunyeong.aw_be.rest.domain.book.Book;
import com.mynameisjunyeong.aw_be.rest.service.BookService;
import com.mynameisjunyeong.aw_be.util.CommonResponse;
import com.mynameisjunyeong.aw_be.util.LogUtil;
import com.mynameisjunyeong.aw_be.util.ResponseUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/book/v1")
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/")
    public CommonResponse createAndWrite(@RequestBody BookCreateDto bookCreateDto){
        LogUtil.inputLog(bookCreateDto);
        Long storyId = 0L;
        try {
            Book book = bookService.create(bookCreateDto.getTextLimit(), bookCreateDto.getGenre(), bookCreateDto.getAuthor(), bookCreateDto.getTitle(), bookCreateDto.getTotalLimit());
            storyId = bookService.write(bookCreateDto.getContents(), book, bookCreateDto.getAuthor());
        } catch (ServiceException se){
            log.error(se.getMessage());
        }

        return ResponseUtil.singleResponse(storyId);
    }

    @GetMapping("/{id}")
    public CommonResponse readBook(@PathVariable Long id){
        LogUtil.inputLog(id);
        ReadBookRes result;
        try {
            result = bookService.read(id);
        } catch (Exception e){
            LogUtil.errorLog(e);
            return ResponseUtil.failResponse();
        }

        return ResponseUtil.singleResponse(result);
    }

/*    @GetMapping("/list")
    public CommonResponse readBooks(){

        try {

        } catch (Exception e) {
            LogUtil.errorLog(e);
            return ResponseUtil.failResponse();
        }
        return ResponseUtil.listResponse();
    }*/
}
