package com.xrzj.decoration.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xrzj.decoration.R;
import com.xrzj.decoration.base.BaseAppCompatActivity;
import com.xrzj.decoration.base.BaseFragmentFactory;
import com.xrzj.decoration.base.BasePagerAdapter;
import com.xrzj.decoration.presenter.IMainPresenter;
import com.xrzj.decoration.presenter.imp.MainPresenterImp;
import com.xrzj.decoration.ui.widget.NoSlidingViewPager;
import com.xrzj.decoration.view.IMainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class MainActivity extends BaseAppCompatActivity implements IMainView{

    @BindView(R.id.vp_home)
    NoSlidingViewPager mVpHome;
    @BindView(R.id.tb_bottom)
    CommonTabLayout mTbBottom;

    private IMainPresenter  mMainPresenter = new MainPresenterImp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mMainPresenter.subscribe();
        mMainPresenter.bindView(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.unSubscribe();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initTabLayout();
        initViewPager();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    private void initViewPager() {
        Log.d("MainActivity","initViewPager");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(BaseFragmentFactory.getInstance().getHomeFragment());
        fragments.add(BaseFragmentFactory.getInstance().getWorkbenchFragment());
        fragments.add(BaseFragmentFactory.getInstance().getCommunicationFragment());
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
        ArrayList<CustomTabEntity> mTabEntities = mMainPresenter.getTabEntity();

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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存BottomBar的状态
        //        mBottomBar.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {

    }
}
