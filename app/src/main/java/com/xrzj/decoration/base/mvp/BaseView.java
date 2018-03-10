package com.xrzj.decoration.base.mvp;

/**
 * MVP模式View层的基类
 * @author: zhoufu
 * @date: On 2018/3/10
 */

public interface BaseView {
    //显示加载框
    void showLoadingProgress(String msg);

    //取消加载框
    void dismissLoadingProgress();
}
