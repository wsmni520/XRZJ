package com.xrzj.decoration.base;


import com.google.gson.Gson;
import com.xrzj.decoration.exception.APIException;
import com.xrzj.decoration.exception.RequestExpiredException;
import com.xrzj.decoration.exception.UnLoginException;
import com.xrzj.decoration.http.IResponse;
import com.xrzj.decoration.utils.ReflectUtil;

import java.io.IOException;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */


public class BaseObserver<T> implements Observer<ResponseBody> {

    private IResponse iResponse;
    private Gson mGson;
    private final Type finalNeedType;
    private static final int UNLOGIN_EXCEPTION = 33333;
    private static final int REQUEST_EXCEPTION = 1003;

    public BaseObserver(IResponse<T> iResponse) {
        this.iResponse = iResponse;
        mGson = new Gson();

        /**
         * 通过反射，拿到类中所有的Interface
         */
        final Type[] types = iResponse.getClass().getGenericInterfaces();

        if (ReflectUtil.MethodHandler(types) == null || ReflectUtil.MethodHandler(types).size() == 0) {

        }
        finalNeedType = ReflectUtil.MethodHandler(types).get(0);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ResponseBody responseBody) {

        try {
            /**
             * responseBody.string()当前打断点，获取不到值，具体原因还未去查找，此处先用result接收
             */
            String result = responseBody.string();
            BaseResponse httpResponse = mGson.fromJson(result,finalNeedType);
            if (httpResponse.isSuccess()) {
                iResponse.onSuccess(httpResponse);
            } else {
                if (httpResponse.getCode() == UNLOGIN_EXCEPTION) {
                    iResponse.onError(new UnLoginException(httpResponse.getCode(), httpResponse.getMessage()));
                } else if (httpResponse.getCode() == REQUEST_EXCEPTION) {
                    iResponse.onError(new RequestExpiredException(httpResponse.getCode(), httpResponse.getMessage()));
                } else {
                    iResponse.onError(new APIException(httpResponse.getCode(), httpResponse.getMessage()));
                }
            }
        } catch (IOException e) {
            iResponse.onError(e);
        }
    }

    @Override
    public void onError(Throwable e) {
        iResponse.onError(e);
    }

    @Override
    public void onComplete() {

    }
}
