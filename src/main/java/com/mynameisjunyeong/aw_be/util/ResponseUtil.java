package com.mynameisjunyeong.aw_be.util;

import org.springframework.data.domain.Page;

import java.util.List;

public final class ResponseUtil {
    private final static String SUCCESS_MSG = "요청 성공";
    private final static String FAIL_MSG = "요청 실패";

    public static <T> SingleResponse<T> singleResponse(T data){
        SingleResponse<T> response = new SingleResponse<>();
        if(data != null){
            response.setData(data);
            successResponse(response);
        } else {
            failResponse(response);
        }
        return response;
    }

    public static <T> ListResponse<T> listResponse(List<T> listData){
        ListResponse<T> response = new ListResponse<>();
        if(listData != null){
            response.setList(listData);
            successResponse(response);
        } else {
            failResponse(response);
        }
        return response;
    }

    public static <T> PageResponse<T> pageResponse(Page<T> pageData){
        PageResponse<T> response = new PageResponse<>();
        if(pageData != null){
            response.setPage(pageData);
            successResponse(response);
        } else {
            failResponse(response);
        }
        return response;
    }


    private static void successResponse(CommonResponse response){
        response.setSuccess(true);
        response.setCode("0");
        response.setMsg(SUCCESS_MSG);
    }

    private static void failResponse(CommonResponse response){
        response.setSuccess(false);
        response.setCode("-1");
        response.setMsg(FAIL_MSG);
    }
}
