package com.xrzj.decoration.ui.workbench.view.fragment;


import android.view.View;
import android.widget.LinearLayout;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.fragment.BaseFragment;
import com.xrzj.decoration.ui.other.collection.view.activity.MyCollectionActivity;
import com.xrzj.decoration.ui.other.order.view.activity.OrderManageActivity;
import com.xrzj.decoration.ui.workbench.contract.WorkbenchContract;
import com.xrzj.decoration.ui.workbench.presenter.WorkbenchPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class WorkbenchFragment extends BaseFragment<WorkbenchContract.Presenter> implements WorkbenchContract.View {


    @BindView(R.id.order_manage_ll)
    LinearLayout mOrderManageLl;
    @BindView(R.id.base_info_ll)
    LinearLayout mBaseInfoLl;
    @BindView(R.id.enter_ll)
    LinearLayout mEnterLl;
    @BindView(R.id.collection_ll)
    LinearLayout mCollectionLl;
    @BindView(R.id.case_manage_ll)
    LinearLayout mCaseManageLl;
    @BindView(R.id.service_help_ll)
    LinearLayout mServiceHelpLl;
    @BindView(R.id.to_do_list_ll)
    LinearLayout mToDoListLl;

    private boolean isDesigner = true;

    @Override
    public int getContentView() {
        return R.layout.workbench_fragment;
    }

    @Override
    public void initView() {
        initBaseViewByUser();

    }

    private void initBaseViewByUser() {
        if(isDesigner){
            mEnterLl.setVisibility(View.VISIBLE);
            mCaseManageLl.setVisibility(View.GONE);
            mToDoListLl.setVisibility(View.GONE);
            mBaseInfoLl.setVisibility(View.GONE);
        } else {
            mEnterLl.setVisibility(View.GONE);
            mCaseManageLl.setVisibility(View.VISIBLE);
            mToDoListLl.setVisibility(View.VISIBLE);
            mBaseInfoLl.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public WorkbenchContract.Presenter initPresenter() {
        return new WorkbenchPresenter(this);
    }

    @Override
    @OnClick({R.id.order_manage_ll, R.id.collection_ll, R.id.enter_ll,
            R.id.base_info_ll,R.id.to_do_list_ll,R.id.service_help_ll,R.id.case_manage_ll})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_manage_ll:
                startActivity(OrderManageActivity.class);
                break;
            case R.id.collection_ll:
                startActivity(MyCollectionActivity.class);
                break;
            case R.id.enter_ll:
                isDesigner = false;
                initBaseViewByUser();
                break;
            case R.id.base_info_ll:
                isDesigner = true;
                initBaseViewByUser();
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
