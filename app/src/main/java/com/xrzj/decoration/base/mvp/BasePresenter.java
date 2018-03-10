package com.xrzj.decoration.base.mvp;

/**
 * MVP模式Presenter层的基类
 * @author: zhoufu
 * @date: On 2018/3/10
 */

public interface BasePresenter{
    //绑定数据
    void subscribe();
    //解除绑定
    void unSubscribe();

}
