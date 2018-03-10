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
        //设置轮播图
        void setBanner(Banner mBanner, List<Object> arrayList);

        void setFunctionButtonOnClick(int position);

        void setPopularBrandItemOnClick(int position);

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
        BaseDelegateAdapter initGvMenu();

        /**
         * 标题栏
         */
        BaseDelegateAdapter initTitle(String title);

        /**
         * 热门品牌栏
         */
        BaseDelegateAdapter initPopularBrand();
    }

}
