package com.xrzj.decoration.ui.home.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.base.fragment.BaseFragment;
import com.xrzj.decoration.ui.home.contract.HomeContract;
import com.xrzj.decoration.ui.home.presenter.HomePresenter;
import com.xrzj.decoration.ui.main.view.MainActivity;
import com.xrzj.decoration.ui.other.find.view.activity.FindDesignerActivity;
import com.xrzj.decoration.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {

    @BindView(R.id.home_recycler)
    RecyclerView mHomeRecycler;
    @BindView(R.id.home_refresh_layout)
    SmartRefreshLayout mHomeRefreshLayout;
    Unbinder unbinder;
    private Banner mBanner;
    private LinkedList<DelegateAdapter.Adapter> mAdapters;
    private MainActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("HomeFragment", "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mActivity != null) {
            mActivity = null;
        }
    }

    @Override
    public int getContentView() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView() {
        Log.d("HomeFragment", "initView");
        mAdapters = new LinkedList<>();
        mPresenter.setActivity(mActivity);
        initRefrshLayout();
        initRecyclerView();
    }

    private void initRefrshLayout() {

    }


    private void initRecyclerView() {
        Log.d("HomeFragment", "initRecyclerView");
        DelegateAdapter delegateAdapter = mPresenter.initRecyclerView(mHomeRecycler);
        //把轮播器添加到集合
        BaseDelegateAdapter bannerAdapter = mPresenter.initBannerAdapter();
        mAdapters.add(bannerAdapter);
        //初始化九宫格
        BaseDelegateAdapter menuAdapter = mPresenter.initGvMenuColumn();
        mAdapters.add(menuAdapter);
        //初始化跑马灯
        BaseDelegateAdapter marqueeViewAdapter = mPresenter.initMarqueeViewColumn();
        mAdapters.add(marqueeViewAdapter);
        //初始化装修相关 计算器
        BaseDelegateAdapter oneplustwoAdapter = mPresenter.initDecorationRelevantColumn(7);
        mAdapters.add(oneplustwoAdapter);
        //初始热门品牌标题栏
        BaseDelegateAdapter popbTitleAdapter = mPresenter.initTitle(mContext.getResources().getString(R.string.popular_brand), 7);
        mAdapters.add(popbTitleAdapter);
        //初始化热门品牌栏
        BaseDelegateAdapter popularBrandAdapter = mPresenter.initPopularBrandColumn();
        mAdapters.add(popularBrandAdapter);
        //初始化效果图标题栏
        BaseDelegateAdapter renderingsTitleAdapter = mPresenter.initTitle(mContext.getResources().getString(R.string.renderings), 0);
        mAdapters.add(renderingsTitleAdapter);
        //初始化效果图栏
        BaseDelegateAdapter renderingsAdapter = mPresenter.initRenderingsColumn();
        mAdapters.add(renderingsAdapter);
        //初始化装修大学标题栏
        BaseDelegateAdapter decorationUniversityTitleAdapter = mPresenter.initTitle(mContext.getResources().getString(R.string.decoration_university), 0);
        mAdapters.add(decorationUniversityTitleAdapter);
        //初始化装修大学栏
        BaseDelegateAdapter decorationUniversityAdapter = mPresenter.initDecorationUvColumn();
        mAdapters.add(decorationUniversityAdapter);
        //初始化休闲娱乐标题栏

        BaseDelegateAdapter entertainmentTitleAdapter = mPresenter.initTitle(mContext.getResources().getString(R.string.entertainment), 0);
        mAdapters.add(entertainmentTitleAdapter);
        //初始化休闲娱乐图标题栏
        BaseDelegateAdapter entertainmentAdapter = mPresenter.initEntertainmentColumn();
        mAdapters.add(entertainmentAdapter);
        delegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void initData() {


    }

    @Override
    public void initListener() {

    }

    @Override
    public HomeContract.Presenter initPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void setBanner(Banner banner, List<Object> arrayList) {
        mBanner = banner;
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(arrayList);
        //设置banner动画效果(默认平滑)
        mBanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        //mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();


    }

    @Override
    public void setPopularBrandItemOnClick(int position) {
        switch (position) {
            case 0:
                Toast.makeText(mActivity, "PopularBrandItem0", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(mActivity, "PopularBrandItem1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mActivity, "PopularBrandItem2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mActivity, "PopularBrandItem3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(mActivity, "PopularBrandItem4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(mActivity, "PopularBrandItem5", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(mActivity, "PopularBrandItem6", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }

    @Override
    public void setMarqueeClick(int position) {
        switch (position) {
            case 1:
                Toast.makeText(mActivity, "1", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void setDecorationUvItemClick(int position) {
        switch (position) {
            case 0:
                Toast.makeText(mActivity, "0", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(mActivity, "1", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void setFunctionButtonOnClick(int position) {
        switch (position) {
            case 0:
                startActivity(FindDesignerActivity.class);
                break;
            case 1:
                Toast.makeText(mActivity, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mActivity, "2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mActivity, "3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(mActivity, "4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(mActivity, "5", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(mActivity, "6", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(mActivity, "7", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void setEntertainmentClick(int position) {
        switch (position) {
            case 0:
                startActivity(FindDesignerActivity.class);
                break;
            case 1:
                Toast.makeText(mActivity, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mActivity, "2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mActivity, "3", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void setDecorationRelevantClick(int position) {
        switch (position) {
            case 0:
                startActivity(FindDesignerActivity.class);
                break;
            case 1:
                Toast.makeText(mActivity, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mActivity, "2", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void setrenderingsItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(FindDesignerActivity.class);
                break;
            case 1:
                Toast.makeText(mActivity, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mActivity, "2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mActivity, "3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(mActivity, "4", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBanner != null) {
            mBanner.startAutoPlay();
        }
    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }

    @Override
    public void onClick(View v) {

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
