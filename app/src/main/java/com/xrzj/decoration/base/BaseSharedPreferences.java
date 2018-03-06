package com.xrzj.decoration.base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class BaseSharedPreferences {
    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "share_data";

    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        String result = sp.getString(key, "");
        return result;
    }

    public static String getString(Context context, String key,
                                   String defaultData) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        String result = sp.getString(key, defaultData);
        return result;
    }

    public static void putString(Context context, String key, String data) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putString(key, data);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        boolean result = sp.getBoolean(key, false);
        return result;
    }

    public static boolean getBoolean(Context context, String key,
                                     Boolean defaultData) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        boolean result = sp.getBoolean(key, defaultData);
        return result;
    }


    public static void putBoolean(Context context, String key,
                                  Boolean data) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putBoolean(key, data);
        editor.commit();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        int result = sp.getInt(key, -1);
        return result;
    }

    public static int getInt(Context context, String key, int defaultData) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        int result = sp.getInt(key, defaultData);
        return result;
    }

    public static void putInt(Context context, String key, int data) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putInt(key, data);
        editor.commit();
    }

    public static long getLong(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        long result = sp.getLong(key, -1);
        return result;
    }

    public static long getLong(Context context, String key, long defaultData) {
        SharedPreferences sp = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        long result = sp.getLong(key, defaultData);
        return result;
    }

    public static void putLong(Context context, String key, long data) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putLong(key, data);
        editor.commit();
    }
}