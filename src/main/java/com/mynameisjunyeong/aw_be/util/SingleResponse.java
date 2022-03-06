package com.mynameisjunyeong.aw_be.util;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SingleResponse<T> extends CommonResponse{
    private T data;
}
