package com.xrzj.decoration.base.observer;


import android.util.Log;

import com.xrzj.decoration.base.response.BaseResponse;
import com.xrzj.decoration.base.response.BaseResult;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */


public abstract class BaseObserver<T> implements Observer<BaseResponse<BaseResult<T>>> {

    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResponse<BaseResult<T>> response) {
        if (response.isSuccess()) {
            //获取网关响应数据
            BaseResult<T> responseDetail = response.getDetail();
            //获取业务响应数据
            if(responseDetail.isSuccess()) {
                T resultDetail = responseDetail.getDetail();
                onSuccess(resultDetail);
            } else {
                onError(responseDetail.getDescription());
            }
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
