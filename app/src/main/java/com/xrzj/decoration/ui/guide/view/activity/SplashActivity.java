package com.xrzj.decoration.ui.guide.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.xrzj.decoration.ui.other.user.view.activity.LoginActivity;
import com.xrzj.decoration.utils.SharedPreferencesUtils;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class SplashActivity extends Activity {


    private Context mContext;
    private static final long WELCOME_VIEW_SHOW_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        mContext = SplashActivity.this;

        boolean isFirstLaunch = SharedPreferencesUtils.isFirstLaunch(mContext);

        if (isFirstLaunch) {
            //设置首次启动为false
            SharedPreferencesUtils.setFirstLaunch(mContext, false);
            //进入导航页
            enterGuidActivity();
            return;
        } else {
            //进入主界面
            enterHomeActivity();
            return;
        }
    }

    private void enterGuidActivity  () {
        guidActivityStart();
        return;
    }

    private void guidActivityStart() {
        Intent intent = new Intent(this, GuidActivity.class);
        startActivity(intent);
        finish();
    }

    private void enterHomeActivity() {
        //延迟2秒进入主界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                homeActivityStart();
            }
        }, WELCOME_VIEW_SHOW_TIME);
        return;
    }

    private void homeActivityStart() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
