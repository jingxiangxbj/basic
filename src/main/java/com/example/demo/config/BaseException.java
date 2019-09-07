package com.example.demo.config;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{
    private int code;
    private String msg;
    public BaseException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(int code,String msg,Throwable cause){
        super(msg,cause);
        this.code = code;
        this.msg = msg;
    }

}
