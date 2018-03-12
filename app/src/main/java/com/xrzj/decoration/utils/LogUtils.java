package com.xrzj.decoration.utils;

import android.util.Log;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class LogUtils {

    public static boolean isDebug = true;
    private static String TAG = "Log日志";
    public static void e(String tag,String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void i(String tag,String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag,String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }



}
