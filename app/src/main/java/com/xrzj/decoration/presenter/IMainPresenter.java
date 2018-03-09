package com.xrzj.decoration.presenter;

import android.app.Activity;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.xrzj.decoration.base.BasePresenter;

import java.util.ArrayList;

/**
 * @author: zhoufu
 * @date: On 2018/3/8
 */

public interface IMainPresenter extends BasePresenter{
    void bindView(Activity activity);
    ArrayList<CustomTabEntity> getTabEntity();
    void getUpdate();
}
