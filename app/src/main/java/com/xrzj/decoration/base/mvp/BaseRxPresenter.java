package com.xrzj.decoration.base.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author: zhoufu
 * @date: On 2018/3/10
 */

public abstract class BaseRxPresenter<V extends BaseView> implements BasePresenter {
    //将所有正在处理的Subscription都添加到CompositeDisposable中。统一退出的时候注销观察
    private CompositeDisposable mCompositeDisposable;
    protected V mView;

    public BaseRxPresenter(V view) {
        this.mView = view;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unSubscribe() {
        this.mView = null;
        unDisposable();
    }

    /**
     * 添加到CompositeDisposable集合中
     */
    public void addDisposable(Disposable subscription) {
        //mCompositeDisposable如果解绑了的话,添加Disposable需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }


    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
    //TODO
    /**
     * 添加订阅事件
     */


}
