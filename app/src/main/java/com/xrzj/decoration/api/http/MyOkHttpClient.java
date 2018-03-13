package com.xrzj.decoration.api.http;


import com.xrzj.decoration.api.cookie.JavaNetCookieJar;
import com.xrzj.decoration.interceptor.HeaderInterceptor;
import com.xrzj.decoration.interceptor.LogInterceptor;
import com.xrzj.decoration.utils.LogUtils;

import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.OkHttpClient;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class MyOkHttpClient {

    private static OkHttpClient singleton;
    private MyOkHttpClient(){
        new RuntimeException("");
    }
    public static OkHttpClient getInstance() {
        if (singleton == null) {
            synchronized (MyOkHttpClient.class) {
                if (singleton == null) {

                    OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

                    if (LogUtils.isDebug) {
                        /**
                         * debug模式下打印json
                         */
                        LogInterceptor logging = new LogInterceptor();
                        okHttpClientBuilder.addInterceptor(logging);
                    }

                    okHttpClientBuilder.addInterceptor(new HeaderInterceptor());
                    CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER);
                    /**
                     * 设置cookie持久化
                     */
                    okHttpClientBuilder.cookieJar(new JavaNetCookieJar(cookieManager));
                    singleton = okHttpClientBuilder.build();
                }
            }
        }
        return singleton;
    }
}
