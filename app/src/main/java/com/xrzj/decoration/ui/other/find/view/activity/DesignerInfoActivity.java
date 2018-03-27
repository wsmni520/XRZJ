package com.xrzj.decoration.ui.other.find.view.activity;

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
import com.xrzj.decoration.ui.other.find.contract.DesignerContract;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;
import com.xrzj.decoration.ui.other.find.view.fragment.DesignCaseFragment;
import com.xrzj.decoration.ui.other.find.view.fragment.DesignerEvaluateFragment;
import com.xrzj.decoration.ui.other.find.view.fragment.DesignerIntroductionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DesignerInfoActivity extends BaseAppCompatActivity<DesignerContract.Presenter> implements DesignerContract.View{

    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.title_right_pre_iv)
    ImageView mTitleRightPreIv;
    @BindView(R.id.title_right_last_iv)
    ImageView mTitleRightLastIv;
    @BindView(R.id.designer_name_tv)
    TextView mDesignerNameTv;
    @BindView(R.id.designer_per_price_tv)
    TextView mDesignerPerPriceTv;
    @BindView(R.id.desiner_info_tab_layout)
    TabLayout mDesinerInfoTabLayout;
    @BindView(R.id.desiner_info_vp)
    ViewPager mDesinerInfoVp;
    private ArrayList<String> mTitleList;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.designer_info_activity;
    }

    @Override
    public void initView() {
        initTitle();
        initFragmentList();
        initViewPagerAndTab();
    }

    private void initTitle() {
        mTvTitle.setVisibility(View.GONE);
        mTitleRightPreIv.setVisibility(View.GONE);
    }

    private void initFragmentList() {
        mTitleList = new ArrayList<>();
        mFragments = new ArrayList<>();
        mTitleList.add("简介");
        mTitleList.add("评价");
        mTitleList.add("案例");
        mFragments.add(new DesignerIntroductionFragment());
        mFragments.add(new DesignerEvaluateFragment());
        mFragments.add(new DesignCaseFragment());
    }

    private void initViewPagerAndTab() {
        /**
         * 注意使用的是：getChildFragmentManager，
         * 这样setOffscreenPageLimit()就可以添加上，保留相邻2个实例，切换时不会卡
         * 但会内存溢出，在显示时加载数据
         */
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BasePagerAdapter myAdapter = new BasePagerAdapter(supportFragmentManager, mFragments,mTitleList);
        mDesinerInfoVp.setAdapter(myAdapter);
        // 左右预加载页面的个数
        mDesinerInfoVp.setOffscreenPageLimit(mFragments.size());
        myAdapter.notifyDataSetChanged();
        mDesinerInfoTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mDesinerInfoTabLayout.setupWithViewPager(mDesinerInfoVp);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public DesignerContract.Presenter initPresenter() {
        return null;
    }

    @Override
    @OnClick({R.id.btnBack})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBack:
                finish();
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
    public void showDesignerRankList(List<Designer> designerList) {

    }

    @Override
    public void showDesignerList(List<Designer> designerList) {

    }
}
