package com.xrzj.decoration.ui.home.contract;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;
import com.youth.banner.Banner;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/10
 */

public interface HomeContract {
    interface View extends BaseView{
        //设置轮播图item点击
        void setBanner(Banner mBanner, List<Object> arrayList);
        //设置功能按钮item点击
        void setFunctionButtonOnClick(int position);
        //设置热门品牌item点击
        void setPopularBrandItemOnClick(int position);
        //设置跑马灯item点击
        void setMarqueeClick(int position);
        //设置休闲娱乐item点击
        void setEntertainmentClick(int position);
        //设置装修计算器、新手指引item点击
        void setDecorationRelevantClick(int position);
        //设置装修大学item点击
        void setDecorationUvItemClick(int position);
        //设置效果图item点击
        void setrenderingsItemClick(int position);
    }

    interface Presenter extends BasePresenter {
        void setActivity(Activity activity);

        /**
         * 初始化RecyclerView
         */
        DelegateAdapter initRecyclerView(RecyclerView recyclerView);

        /**
         * 广告位栏
         */
        BaseDelegateAdapter initBannerAdapter();

        /**
         * 功能菜单栏
         */
        BaseDelegateAdapter initGvMenuColumn();

        /**
         * 标题栏
         */
        BaseDelegateAdapter initTitle(String title,int marginTop);

        /**
         * 热门品牌栏
         */
        BaseDelegateAdapter initPopularBrandColumn();

        /**
         * 最新信息跑马灯栏
         */
        BaseDelegateAdapter initMarqueeViewColumn();

        /**
         * 休闲娱乐栏
         */
        BaseDelegateAdapter initEntertainmentColumn();

        /**
         * 装修相关 1拖2
         */
        BaseDelegateAdapter initDecorationRelevantColumn(int marginTop);
        /**
         * 装修大学栏
         */
        BaseDelegateAdapter initDecorationUvColumn();
        /**
         * 效果图栏
         */
        BaseDelegateAdapter initRenderingsColumn();
    }



}
