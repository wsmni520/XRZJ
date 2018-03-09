package com.xrzj.decoration.presenter;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.xrzj.decoration.base.BasePresenter;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.ui.activity.MainActivity;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public interface IHomePresenter extends BasePresenter {
    void setActivity(MainActivity activity);

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
