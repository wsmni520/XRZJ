package com.xrzj.decoration.ui.other.user.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.ui.other.user.contract.RegistContract;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class RegistActivity extends BaseAppCompatActivity<RegistContract.Presenter> implements RegistContract.View {

    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.regist_user_name_edt)
    EditText mRegistUserNameEdt;
    @BindView(R.id.et_regist_user_phone)
    EditText mEtRegistUserPhone;
    @BindView(R.id.iv_regist_clear_phonenum)
    ImageView mIvRegistClearPhonenum;
    @BindView(R.id.tv_send_msg)
    TextView mTvSendMsg;
    @BindView(R.id.et_regist_msg_code)
    EditText mEtRegistMsgCode;
    @BindView(R.id.im_regist_clear_msg_code)
    ImageView mImRegistClearMsgCode;
    @BindView(R.id.et_regist_uer_pwd)
    EditText mEtRegistUerPwd;
    @BindView(R.id.iv_regist_clear_user_pwd)
    ImageView mIvRegistClearUserPwd;
    @BindView(R.id.im_regist_show_user_pwd)
    ImageView mImRegistShowUserPwd;
    @BindView(R.id.btn_regist_account)
    Button mBtnRegistAccount;
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.regist_activity;
    }

    @Override
    public void initView() {
        mTvTitle.setText(R.string.regist);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public RegistContract.Presenter initPresenter() {
        return null;
    }

    @Override
    @OnClick({R.id.btnBack})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
                break;
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
