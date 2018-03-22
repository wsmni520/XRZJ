package com.xrzj.decoration.ui.other.order.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.base.adapter.BasePagerAdapter;
import com.xrzj.decoration.ui.other.order.contract.OrderManageContract;
import com.xrzj.decoration.ui.other.order.view.fragment.DesignerOrderFragment;
import com.xrzj.decoration.ui.other.order.view.fragment.ManagerOrderManageFragment;
import com.xrzj.decoration.ui.other.order.view.fragment.MaterialOrderManageFragment;
import com.xrzj.decoration.ui.other.order.view.fragment.SupervisorOrderManageFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderManageActivity extends BaseAppCompatActivity<OrderManageContract.Presenter> implements OrderManageContract.View {

    @BindView(R.id.order_manage_tab_layout)
    TabLayout mOrderManageTabLayout;
    @BindView(R.id.order_manage_vp)
    ViewPager mOrderManageVp;
    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.title_right_pre_iv)
    ImageView mTitleRightPreIv;
    @BindView(R.id.title_right_last_iv)
    ImageView mTitleRightLastIv;
    private List<String> mTitleList;
    private List<Fragment> mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.order_manage_activity;
    }

    @Override
    public void initView() {
        initTitle();
        initOrderManageFragmentList();
        initViewPagerAndTab();
    }

    private void initTitle() {
        mTitleRightPreIv.setVisibility(View.GONE);
    }

    private void initViewPagerAndTab() {
        /**
         * 注意使用的是：getChildFragmentManager，
         * 这样setOffscreenPageLimit()就可以添加上，保留相邻2个实例，切换时不会卡
         * 但会内存溢出，在显示时加载数据
         */
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BasePagerAdapter myAdapter = new BasePagerAdapter(supportFragmentManager, mFragments,mTitleList);
        mOrderManageVp.setAdapter(myAdapter);
        // 左右预加载页面的个数
        mOrderManageVp.setOffscreenPageLimit(mFragments.size());
        myAdapter.notifyDataSetChanged();
        mOrderManageTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mOrderManageTabLayout.setupWithViewPager(mOrderManageVp);

    }

    private void initOrderManageFragmentList() {
        final String[] proName = this.getResources().getStringArray(R.array.order_manage_tab);
        mTitleList = Arrays.asList(proName);
        mFragments = new ArrayList<>();
        mFragments.add(new DesignerOrderFragment());
        mFragments.add(new ManagerOrderManageFragment());
        mFragments.add(new MaterialOrderManageFragment());
        mFragments.add(new SupervisorOrderManageFragment());
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public OrderManageContract.Presenter initPresenter() {
        return null;
    }

    @Override
    @OnClick({R.id.btnBack})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack :
                finish();
                break;
            default :
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
