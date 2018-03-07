package com.xrzj.decoration.exception;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class UnLoginException extends APIException {
    public UnLoginException(int code, String message) {
        super(code, message);
    }
}