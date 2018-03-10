package com.xrzj.decoration.ui.main.contract;


import android.app.Activity;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;

import java.util.ArrayList;


public interface MainContract {

    /**
     * View(activity/fragment)继承，需要实现的方法
     */
    interface View extends BaseView {

    }

    /**
     * Presenter控制器
     */
    interface Presenter extends BasePresenter {
        void setActivity(Activity activity);
        ArrayList<CustomTabEntity> getTabEntity();
    }


}
