package com.xrzj.decoration.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.BaseAppCompatActivity;
import com.xrzj.decoration.presenter.ILoginPresenter;
import com.xrzj.decoration.presenter.imp.LoginPresenterImpl;
import com.xrzj.decoration.view.ILoginView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author: zhoufu
 * @date: On 2018/3/6
 */

public class LoginActivity extends BaseAppCompatActivity implements ILoginView {


    @BindView(R.id.btnBack)
    ImageButton mBtnBack;
    @BindView(R.id.tv_user_phonenum)
    EditText mTvUserPhonenum;
    @BindView(R.id.tv_login_msg_code)
    EditText mTvLoginMsgCode;
    @BindView(R.id.im_login_show_user_pwd)
    ImageView mImLoginShowUserPwd;
    @BindView(R.id.tv_login_user_pwd)
    EditText mTvLoginUserPwd;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginPresenter = new LoginPresenterImpl(this);

    }

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFailed(String errorMessage) {

    }

    @Override
    @OnClick(R.id.login_btn)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                Toast.makeText(this,"login",Toast.LENGTH_SHORT).show();
                mLoginPresenter.login(mTvUserPhonenum.getText().toString().trim(), mTvLoginUserPwd.getText().toString().trim());
                break;
            case R.id.btnBack:
                Toast.makeText(this,"back",Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }
}
