package com.xrzj.decoration.ui.other.collection.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.base.adapter.BasePagerAdapter;
import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.ui.other.collection.view.fragment.CaseCollectionFragment;
import com.xrzj.decoration.ui.other.collection.view.fragment.DesignerCollectionFragment;
import com.xrzj.decoration.ui.other.collection.view.fragment.MangerCollectionFragment;
import com.xrzj.decoration.ui.other.collection.view.fragment.MaterialCollectionFragment;
import com.xrzj.decoration.ui.other.collection.view.fragment.SupervisorCollectionFragment;
import com.xrzj.decoration.widget.NoSlidingViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyCollectionActivity extends BaseAppCompatActivity {

    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.title_right_pre_iv)
    ImageView mTitleRightPreIv;
    @BindView(R.id.title_right_last_iv)
    ImageView mTitleRightLastIv;
    @BindView(R.id.my_collection_tab_layout)
    TabLayout mMyCollectionTabLayout;
    @BindView(R.id.my_collection_vp)
    NoSlidingViewPager mMyCollectionVp;

    private List<String> mTitleList;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.my_collection_activity;
    }

    @Override
    public void initView() {
        initTitle();
        initCollectionFragmentList();
        initViewPagerAndTab();

    }

    private void initViewPagerAndTab() {
        /**
         * 注意使用的是：getChildFragmentManager，
         * 这样setOffscreenPageLimit()就可以添加上，保留相邻2个实例，切换时不会卡
         * 但会内存溢出，在显示时加载数据
         */
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BasePagerAdapter myAdapter = new BasePagerAdapter(supportFragmentManager, mFragments,mTitleList);
        mMyCollectionVp.setAdapter(myAdapter);
        // 左右预加载页面的个数
        mMyCollectionVp.setOffscreenPageLimit(mFragments.size());
        myAdapter.notifyDataSetChanged();
        mMyCollectionTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mMyCollectionTabLayout.setupWithViewPager(mMyCollectionVp);
    }

    private void initCollectionFragmentList() {
        final String[] proName = this.getResources().getStringArray(R.array.my_collection_tab);
        mTitleList = Arrays.asList(proName);
        mFragments = new ArrayList<>();
        mFragments.add(new DesignerCollectionFragment());
        mFragments.add(new CaseCollectionFragment());
        mFragments.add(new MangerCollectionFragment());
        mFragments.add(new SupervisorCollectionFragment());
        mFragments.add(new MaterialCollectionFragment());
    }

    private void initTitle() {
        mTvTitle.setText(R.string.my_collection_title);
        mTitleRightPreIv.setVisibility(View.GONE);
        mTitleRightLastIv.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public BasePresenter initPresenter() {
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
