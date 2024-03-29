package com.example.demo.entity;

public enum BaseCode {
    SUCCESS(200,"成功"),
    FAIL(500,"内部服务器错误"),
    SYSTEM_FAIL(100,"系统错误");
    private int code;
    private String msg;

    BaseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
