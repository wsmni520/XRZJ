package com.xrzj.decoration.ui.other.find.contract;

import android.app.Activity;

import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public interface DesignerContract {
    interface View extends BaseView {
        /**
         * 显示设计师等级排行
         * @param designerList
         */
        void showDesignerRankList(List<Designer> designerList);

        /**
         * 显示设计师列表
         * @param designerList
         */
        void showDesignerList(List<Designer> designerList);

    }
    interface Presenter extends BasePresenter {

        void setActivity(Activity activity);

        /**
         * 获取设计师数据列表
         */
        void getDesignerList();

    }

}

