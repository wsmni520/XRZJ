package com.xrzj.decoration.ztest.test1;

import android.util.Log;

import com.xrzj.decoration.api.apiservice.ApiService;
import com.xrzj.decoration.api.http.RequestUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public class TestModel implements BaseTestModel {
    @Override
    public void search(String ip, final AsyncCallback callBack) {
        Log.d("Test2Model","search");
        RequestUtil.getCutomService(ApiService.class)
                .executeGet(ip)
                //在主线程中观察
                .observeOn(AndroidSchedulers.mainThread())
                //在新线程中执行网络请求
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<IPHttpResult<TestBean>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull IPHttpResult<TestBean> testBeanIPHttpResult) {
                        callBack.OnSuccessed(testBeanIPHttpResult.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                callBack.OnFialded("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            callBack.OnFialded("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            callBack.OnFialded("网络连接超时!!");
                        } else {
                            callBack.OnFialded("发生未知错误" + e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}

