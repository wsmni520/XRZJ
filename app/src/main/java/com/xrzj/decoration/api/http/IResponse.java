package com.xrzj.decoration.api.http;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */


public interface IResponse<T> {

    void onSuccess(T baseModel);

    void onError(Throwable e);
}
