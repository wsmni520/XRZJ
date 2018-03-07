package com.xrzj.decoration.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("User-Agent", "Zero")
                .build();
        return chain.proceed(request);
    }
}