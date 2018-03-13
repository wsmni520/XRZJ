package com.xrzj.decoration.api.http;


import android.text.TextUtils;
import android.util.Log;

import com.xrzj.decoration.api.apiservice.ApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class RetrofitFactory {

    private RetrofitFactory() {
        new RuntimeException("");
    }

    private static OkHttpClient httpClient = MyOkHttpClient.getInstance();

    private static ApiService retrofitService;

    private static String baseUrl = "";

    private static Retrofit retrofit;

    /**
     * 默认为ApiService
     *
     * @return
     */
    public static ApiService getInstance() {
        if (retrofitService == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofitService == null) {
                    retrofitService = getInstanceRetrofit().create(ApiService.class);
                }
            }
        }
        return retrofitService;
    }

    /**
     * baseUrl
     */
    private static void getBaseUrl() {
        baseUrl = HttpConfig.getServer();
        Log.d("RetrofitFactory",baseUrl);
    }

    private static Retrofit getInstanceRetrofit() {
        Log.d("RetrofitFactory","getInstanceRetrofit");
        if (retrofit == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofit == null) {
                    if (TextUtils.isEmpty(baseUrl)) {
                        getBaseUrl();
                    }

                    retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(httpClient)
                            .build();
                }
            }
        }
        return retrofit;
    }

    /**
     * 用于创建自定义的apiService
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T createRetrofitService(final Class<T> clazz) {
        return getInstanceRetrofit().create(clazz);
    }
}
