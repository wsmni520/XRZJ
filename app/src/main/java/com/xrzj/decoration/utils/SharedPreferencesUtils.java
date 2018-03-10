package com.xrzj.decoration.utils;

import android.content.Context;
import android.util.Log;

import com.xrzj.decoration.base.uitls.BaseSharedPreferences;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class SharedPreferencesUtils extends BaseSharedPreferences {
    private static String TAG = "SharedPreferencesUtils";
    private static final String FIRST_LAUNCH = "first_launch";


    /**
     * 判断是否时首次启动app
     * @param context
     * @return
     */
    public static boolean isFirstLaunch(Context context) {
        Log.i(TAG, "isFirstLaunch = " + getBoolean(context, FIRST_LAUNCH, true));
        return getBoolean(context, FIRST_LAUNCH, true);
    }

    /**
     * 保存app启动的状态，如果启动过则参数isFisrtLaunch为false
     * @param context
     * @param isFisrtLaunch 是否已经启动过
     */
    public static void setFirstLaunch(Context context, boolean isFisrtLaunch) {
        putBoolean(context, FIRST_LAUNCH, isFisrtLaunch);
    }


}
