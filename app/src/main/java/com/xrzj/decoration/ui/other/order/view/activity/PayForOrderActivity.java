package com.xrzj.decoration.ui.other.order.view.activity;

import android.os.Bundle;
import android.view.View;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.ui.other.order.contract.PayForOrderContract;

public class PayForOrderActivity extends BaseAppCompatActivity<PayForOrderContract.Presenter> implements PayForOrderContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.pay_for_order_activity;
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
    public PayForOrderContract.Presenter initPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }
}
