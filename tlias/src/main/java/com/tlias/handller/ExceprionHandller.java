package com.tlias.handller;

import com.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceprionHandller {

    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        log.error("系统异常", e);
        return Result.error("系统异常");
    }
}
