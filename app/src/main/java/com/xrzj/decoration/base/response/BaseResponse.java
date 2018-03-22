package com.xrzj.decoration.base.response;

import java.io.Serializable;

/**
 * {"code": 0,"description": "ok","detail": {}}
 * 由于公司代码最外层都是这个格式，所以采用这个方式包裹
 *
 * @param <T>
 */
public class BaseResponse<T> implements Serializable {
    private int code;
    private String description;
    private T detail;
    private static int SUCCESS_CODE=200;



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public boolean isSuccess() {
        return code == SUCCESS_CODE;
    }

}
