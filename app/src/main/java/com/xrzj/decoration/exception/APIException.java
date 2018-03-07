package com.xrzj.decoration.exception;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class APIException extends RuntimeException {
    private int code;
    private String message;

    public APIException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}