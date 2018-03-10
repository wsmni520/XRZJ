package com.xrzj.decoration.ui.other.user.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.ui.main.view.MainActivity;
import com.xrzj.decoration.ui.other.user.contract.LoginContract;
import com.xrzj.decoration.ui.other.user.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author: zhoufu
 * @date: On 2018/3/6
 */

public class LoginActivity extends BaseAppCompatActivity<LoginContract.Presenter> implements LoginContract.View {


    @BindView(R.id.login_user_name_edt)
    EditText mEtUserPhonenum;
    @BindView(R.id.login_msg_code_edt)
    EditText mEtLoginMsgCode;
    @BindView(R.id.iv_login_show_user_pwd)
    ImageView mImLoginShowUserPwd;
    @BindView(R.id.login_user_pwd_edt)
    EditText mEtLoginUserPwd;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.get_msg_code_btn)
    Button mGetMsgCodeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getContentView() {
        return R.layout.login_activity;
    }

    @Override
    public void initView() {
        //设置标题
        mTvTitle.setText(R.string.login);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
    }

    @Override
    public LoginContract.Presenter initPresenter() {
        return new LoginPresenterImpl(this);
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
    @OnClick({R.id.login_btn, R.id.btnBack})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
                mPresenter.login(mEtUserPhonenum.getText().toString().trim(), mEtLoginUserPwd.getText().toString().trim());
                break;
            case R.id.btnBack:
                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }
}
