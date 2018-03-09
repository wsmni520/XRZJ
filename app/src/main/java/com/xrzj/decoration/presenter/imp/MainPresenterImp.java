package com.xrzj.decoration.presenter.imp;

import android.app.Activity;
import android.content.res.TypedArray;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.xrzj.decoration.R;
import com.xrzj.decoration.entity.TabEntity;
import com.xrzj.decoration.presenter.IMainPresenter;
import com.xrzj.decoration.view.IMainView;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
/**
 * @author: zhoufu
 * @date: On 2018/3/8
 */

public class MainPresenterImp implements IMainPresenter{
    private IMainView mMainView;
    private final CompositeDisposable mCompositeDisposable;
    private Activity mActivity;

    public MainPresenterImp(IMainView view) {
        this.mMainView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        if (null != mCompositeDisposable) {
            mCompositeDisposable.clear();
        }
        mActivity = null;
    }

    @Override
    public void bindView(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public ArrayList<CustomTabEntity> getTabEntity() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        TypedArray mIconUnSelectIds = mActivity.getResources().obtainTypedArray(R.array.main_tab_un_select);
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

    @Override
    public void getUpdate() {

    }
}
