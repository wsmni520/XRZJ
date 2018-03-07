package com.xrzj.decoration.exception;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class RequestExpiredException extends APIException {
    public RequestExpiredException(int code, String message) {
        super(code, message);
    }
}