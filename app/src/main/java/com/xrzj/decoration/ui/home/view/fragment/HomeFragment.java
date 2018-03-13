package com.xrzj.decoration.ui.home.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.xrzj.decoration.R;
import com.xrzj.decoration.base.fragment.BaseFragment;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.ui.home.contract.HomeContract;
import com.xrzj.decoration.ui.home.presenter.HomePresenter;
import com.xrzj.decoration.ui.main.view.MainActivity;
import com.xrzj.decoration.ui.other.designer.view.activity.FindDesignerActivity;
import com.xrzj.decoration.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View{

    @BindView(R.id.home_recycler)
    RecyclerView mHomeRecycler;
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
        if(mActivity!=null){
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
        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d("HomeFragment", "initRecyclerView");
        DelegateAdapter delegateAdapter = mPresenter.initRecyclerView(mHomeRecycler);
        //把轮播器添加到集合
        BaseDelegateAdapter bannerAdapter = mPresenter.initBannerAdapter();
        mAdapters.add(bannerAdapter);
        //初始化九宫格
        BaseDelegateAdapter menuAdapter = mPresenter.initGvMenu();
        mAdapters.add(menuAdapter);
        //初始化标题
        BaseDelegateAdapter titleAdapter = mPresenter.initTitle("热卖品牌");
        mAdapters.add(titleAdapter);
        //初始化热门品牌栏
        BaseDelegateAdapter popularBrandAdapter = mPresenter.initPopularBrand();
        mAdapters.add(popularBrandAdapter);
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
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //        //设置标题集合（当banner样式有显示title时）
        //        mBanner.setBannerTitles(titles);
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
        switch (position){
            case 0:
                Toast.makeText(mActivity,"PopularBrandItem0",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(mActivity,"PopularBrandItem1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mActivity,"PopularBrandItem2",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mActivity,"PopularBrandItem3",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(mActivity,"PopularBrandItem4",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(mActivity,"PopularBrandItem5",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(mActivity,"PopularBrandItem6",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }

    @Override
    public void setFunctionButtonOnClick(int position) {
        switch (position){
            case 0:
                startActivity(FindDesignerActivity.class);
                break;
            case 1:
                Toast.makeText(mActivity,"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mActivity,"2",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mActivity,"3",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(mActivity,"4",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(mActivity,"5",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(mActivity,"6",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(mActivity,"7",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mBanner!=null){
            mBanner.stopAutoPlay();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mBanner!=null){
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
}
