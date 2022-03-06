package com.mynameisjunyeong.aw_be.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@Component
public class LogUtil {

    public static void inputLog(Object ob){
        for(Field field: ob.getClass().getFields()){
            log.info("{} : {} is {}", ob.getClass().getName(), field.getName(), field.toString());
        }
    }

    public static void errorLog(Exception e){
        log.error(e.getMessage());
    }
}
