package com.xrzj.decoration.api.http;


import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 请求的封装入口
 * Created by Zero on 2017/5/25.
 */

public class RequestUtil {

    /**
     * 自定义ApiService
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getCutomService(Class<T> clazz) {
        return RetrofitFactory.createRetrofitService(clazz);
    }

    /**************************************post**************************************/

    public static <T> void postDispose(String url, Map map, final IResponse<T> iResponse) {

        Observable<ResponseBody> observable = RetrofitFactory.getInstance().executePost(url, map);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

}
