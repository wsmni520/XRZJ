package com.xrzj.decoration.base.observer;


import android.util.Log;

import com.xrzj.decoration.base.response.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */


public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResponse<T> response) {
        if (response.isSuccess()) {
            T t = response.getDetail();
            onSuccess(t);
        } else {
            onError(response.getDescription());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "error:" + e.toString());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }


    protected abstract void onSuccess(T t);

    protected abstract void onError(String msg);

}
