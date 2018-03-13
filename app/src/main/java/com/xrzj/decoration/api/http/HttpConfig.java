package com.xrzj.decoration.api.http;

import android.util.Log;

import com.xrzj.decoration.utils.LogUtils;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class HttpConfig {


    private static final boolean IS_DEBUG = LogUtils.isDebug;
    private static final String DEBUG_SERVER="http://ip.taobao.com/";
    private static final String OFFICAL_SERVER ="http://xxx.com/interface.php?";
    private static final String SPRIT = "/";
    public static String getServer()
    {
        if(IS_DEBUG)
        {
            Log.d("HttpConfig","DEBUG_SERVER");
            return baseUrl(DEBUG_SERVER);
        }
        else {
            return baseUrl(OFFICAL_SERVER);
        }
    }

    private static String baseUrl(String baseUrl){
        if (!baseUrl.endsWith(SPRIT)) {
            baseUrl += SPRIT;
        }
        return baseUrl;
    }
}
