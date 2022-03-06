package com.mynameisjunyeong.aw_be.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter @Setter
public class PageResponse<T> extends CommonResponse{
    private Page<T> page;
}
