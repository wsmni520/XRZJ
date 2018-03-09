package com.xrzj.decoration.base;

/**
 * @author: zhoufu
 * @date: On 2018/3/8
 */

public interface BasePresenter {
    //绑定数据
    void subscribe();
    //解除绑定
    void unSubscribe();
}
