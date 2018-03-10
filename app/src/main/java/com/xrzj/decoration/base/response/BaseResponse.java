package com.xrzj.decoration.base.response;

import java.io.Serializable;

/**
 * {"code": 0,"message": "ok","result": {}}
 * 由于公司代码最外层都是这个格式，所以采用这个方式包裹
 *
 * @param <T>
 */
public class BaseResponse<T> implements Serializable {
    private int code;
    private String message;
    private T result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return code == 0;
    }
}
