package com.xrzj.decoration.ui.workbench.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.fragment.BaseFragment;
import com.xrzj.decoration.ui.other.order.view.activity.OrderManageActivity;
import com.xrzj.decoration.ui.workbench.contract.WorkbenchContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class WorkbenchFragment extends BaseFragment<WorkbenchContract.Presenter> implements WorkbenchContract.View {

    @BindView(R.id.order_manage_iv)
    ImageView mOrderManageIv;
    @BindView(R.id.order_manage_tv)
    TextView mOrderManageTv;
    Unbinder unbinder;

    @Override
    public int getContentView() {
        return R.layout.workbench_fragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public WorkbenchContract.Presenter initPresenter() {
        return null;
    }

    @Override
    @OnClick({R.id.order_manage_iv})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_manage_iv:
                startActivity(OrderManageActivity.class);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
