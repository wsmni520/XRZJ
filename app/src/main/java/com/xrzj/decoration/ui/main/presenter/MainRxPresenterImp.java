package com.xrzj.decoration.ui.main.presenter;

import android.app.Activity;
import android.content.res.TypedArray;
import android.util.Log;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.xrzj.decoration.R;
import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.model.entity.TabEntity;
import com.xrzj.decoration.ui.main.contract.MainContract;

import java.util.ArrayList;

/**
 * @author: zhoufu
 * @date: On 2018/3/8
 */

public class MainRxPresenterImp extends BaseRxPresenter<MainContract.View> implements MainContract.Presenter{
    private Activity mActivity;

    public MainRxPresenterImp(MainContract.View view) {
        super(view);
    }

    @Override
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public ArrayList<CustomTabEntity> getTabEntity() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        Log.d("mActivity","mActivity = null is "+ (mActivity ==null));
        TypedArray mIconUnSelectIds = mActivity.getResources().obtainTypedArray(R.array.main_tab_unselect);
        TypedArray mIconSelectIds = mActivity.getResources().obtainTypedArray(R.array.main_tab_select);
        String[] mainTitles = mActivity.getResources().getStringArray(R.array.main_title);
        for (int i = 0; i < mainTitles.length; i++) {
            int unSelectId = mIconUnSelectIds.getResourceId(i, R.mipmap.tab_home_unselect);
            int selectId = mIconSelectIds.getResourceId(i, R.mipmap.tab_home_select);
            mTabEntities.add(new TabEntity(mainTitles[i],selectId , unSelectId));
        }
        mIconUnSelectIds.recycle();
        mIconSelectIds.recycle();
        return mTabEntities;
    }

}
