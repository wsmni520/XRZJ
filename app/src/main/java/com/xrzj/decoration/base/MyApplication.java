package com.xrzj.decoration.base;

import android.app.Application;
import android.content.Context;

/**
 * @author: zhoufu
 * @date: On 2018/3/6
 */

public class MyApplication extends Application{
    private static Context mContext;
    public static boolean isDebug = true;
    public static String APP_NAME = "Xrzj";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getInstance() {
        return mContext;
    }
}
