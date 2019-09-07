package com.example.demo.interceptor;

import com.example.demo.config.BaseException;
import com.example.demo.entity.BaseCode;
import com.example.demo.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        return Result.error(BaseCode.SYSTEM_FAIL.getCode(), BaseCode.SYSTEM_FAIL.getMsg());
    }

    @ExceptionHandler(BaseException.class)
    public Result<Void> handleException(BaseException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

}
