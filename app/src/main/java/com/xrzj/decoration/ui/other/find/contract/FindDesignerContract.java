package com.xrzj.decoration.ui.other.find.contract;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public interface FindDesignerContract {

    interface View extends BaseView{
//        /**
//         * 显示设计师等级排行
//         * @param designerList
//         */
//        void showDesignerRankList(List<Designer> designerList);


//        /**
//         * 显示设计师列表
//         * @param designerList
//         */
//        void showDesignerList(List<Designer> designerList);
        /**
         * 设计师等级排行版item点击事件
         * @param position 点击位置
         */
        void setDesignerRankListItemClick(int position);
        /**
         * 下拉框点击事件
         * @param view 点击的控件
         */
        void setDropdownBoxItemClick(android.view.View view);
        /**
         * 设计师列表点击事件
         * @param position 点击位置
         */
        void setDesignerListItemClick(int position);
        /**
         * 设计师排序点击事件
         *
         */
        void setDesignerListOrderItemClick(android.view.View view);

    }

    interface Presenter extends BasePresenter{
        void setActivity(Activity activity);
        /**
         * 获取默认设计师数据列表
         */
        void getDesignerList();

        /**
         * 获取设计师等级列表
         */
        void getDesignerRankList();

        /**
         * 初始化RecyclerView
         */
        DelegateAdapter initRecyclerView(RecyclerView recyclerView);

        /**
         * 初始化设计师等级列表栏Adapter
         */
        BaseDelegateAdapter initDesignerRankListAdapter();
        /**
         * 初始化下拉框列表栏Adapter
         */
        BaseDelegateAdapter initDropdownBoxAdapter();
        /**
         * 初始化设计师列表栏Adapter
         */
        BaseDelegateAdapter initDesignerListAdapter();
        /**
         * 初始化设计师排序栏
         */
        BaseDelegateAdapter initDesignerListSortAdapter();
    }

}
