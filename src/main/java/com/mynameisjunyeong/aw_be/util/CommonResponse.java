package com.mynameisjunyeong.aw_be.util;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommonResponse {
    private boolean isSuccess;
    private String code;
    private String msg;
}
