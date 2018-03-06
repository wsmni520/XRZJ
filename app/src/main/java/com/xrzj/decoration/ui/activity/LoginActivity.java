package com.xrzj.decoration.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.BaseFragmentActivity;
import com.xrzj.decoration.view.ILoginView;


/**
 * @author: zhoufu
 * @date: On 2018/3/6
 */

public class LoginActivity extends BaseFragmentActivity implements ILoginView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setSteepStatusBar(false);
        setAllowFullScreen(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    protected void initToolBar() {

    }


    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed(String errorMessage) {

    }
}
