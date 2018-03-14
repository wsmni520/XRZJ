package com.xrzj.decoration.ui.main.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.base.adapter.BasePagerAdapter;
import com.xrzj.decoration.base.fragment.BaseFragmentFactory;
import com.xrzj.decoration.ui.main.contract.MainContract;
import com.xrzj.decoration.ui.main.presenter.MainRxPresenterImp;
import com.xrzj.decoration.widget.NoSlidingViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class MainActivity extends BaseAppCompatActivity<MainContract.Presenter> implements MainContract.View{

    @BindView(R.id.vp_home)
    NoSlidingViewPager mVpHome;
    @BindView(R.id.tb_bottom)
    CommonTabLayout mTbBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public int getContentView() {
        return R.layout.main_activity;
    }

    @Override
    public void initView() {
        mPresenter.setActivity(this);
        initTabLayout();
        initViewPager();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public MainContract.Presenter initPresenter() {
        return new MainRxPresenterImp(this);
    }

    private void initViewPager() {
        Log.d("MainActivity","initViewPager");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(BaseFragmentFactory.getInstance().getHomeFragment());
        fragments.add(BaseFragmentFactory.getInstance().getWorkbenchFragment());
        fragments.add(BaseFragmentFactory.getInstance().getMessageFragment());
        fragments.add(BaseFragmentFactory.getInstance().getUserFragment());

        BasePagerAdapter adapter = new BasePagerAdapter(getSupportFragmentManager(), fragments);
        mVpHome.setAdapter(adapter);
        mVpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mTbBottom.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mVpHome.setOffscreenPageLimit(4);
        mVpHome.setCurrentItem(0);
    }

    /**
     * 初始化底部导航栏数据
     */
    private void initTabLayout() {
        Log.d("MainActivity","initViewPager");
        ArrayList<CustomTabEntity> mTabEntities = this.mPresenter.getTabEntity();

        Log.d("MainActivity","mTbBottom is null " + (mTbBottom ==null));
        mTbBottom.setTabData(mTabEntities);
        //ctlTable.showDot(3);                   //显示红点
        //ctlTable.showMsg(2,5);                 //显示未读信息
        //ctlTable.showMsg(1,3);                 //显示未读信息
        //ctlTable.setMsgMargin(1, 2, 2);        //显示红点信息位置
        mTbBottom.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVpHome.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
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
