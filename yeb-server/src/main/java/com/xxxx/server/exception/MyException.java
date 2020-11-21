package com.xxxx.server.exception;

public class MyException extends RuntimeException{
    private  String msg;
    private Integer code;

    public MyException(Integer code) {
        this.code = code;
    }

    public MyException(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
