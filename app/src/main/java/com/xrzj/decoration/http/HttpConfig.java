package com.xrzj.decoration.http;

import android.util.Log;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class HttpConfig {

    //服务器地址
    private static final boolean isDebug=true;
    private static final String DEBUG_SERVER="http://ip.taobao.com/";
    private static final String OFICAL_SERVER="http://xxx.com/interface.php?";

    public static String getServer()
    {
        if(isDebug)
        {
            Log.d("HttpConfig","DEBUG_SERVER");
            return baseUrl(DEBUG_SERVER);
        }
        else {
            return baseUrl(OFICAL_SERVER);
        }
    }

    private static String baseUrl(String baseUrl){
        if (!baseUrl.endsWith("/")) {
            baseUrl += "/";
        }
        return baseUrl;
    }
}
