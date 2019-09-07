package com.example.demo.entity;

import lombok.Data;

@Data
public class Result<T> {
    private String msg;
    private int code;
    private T data;

    public Result(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = (T) data;
    }
    public Result(String msg,int code){
        this.msg = msg;
        this.code = code;
    }

    public Result() {
    }

    public static <T> Result success(T data){
        return new Result("成功",200,data);
    }

    public static <T> Result error(int code,String msg){
        return new Result(msg,code);
    }


}
