package com.xrzj.decoration.base.response;

import java.io.Serializable;

/**
 * {"code": 0,"description": "ok","detail": {}}
 * 由于公司代码业务层返回都是这个格式，所以采用这个方式包裹
 *
 * @param <T>
 */
public class BaseResult<T> implements Serializable {
    private int bizCode;
    private String bizMessage;
    private T bizData;
    private static int SUCCESS_CODE=1;



    public int getCode() {
        return bizCode;
    }

    public void setCode(int code) {
        this.bizCode = code;
    }

    public String getDescription() {
        return bizMessage;
    }

    public void setDescription(String description) {
        this.bizMessage = description;
    }

    public T getDetail() {
        return bizData;
    }

    public void setDetail(T detail) {
        this.bizData = detail;
    }

    public boolean isSuccess() {
        return bizCode == SUCCESS_CODE;
    }

}
