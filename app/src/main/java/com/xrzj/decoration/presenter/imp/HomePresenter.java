package com.xrzj.decoration.presenter.imp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.xrzj.decoration.R;
import com.xrzj.decoration.api.Constant;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.base.viewholder.BaseViewHolder;
import com.xrzj.decoration.model.IHomeModel;
import com.xrzj.decoration.model.imp.HomeModel;
import com.xrzj.decoration.presenter.IHomePresenter;
import com.xrzj.decoration.ui.activity.MainActivity;
import com.xrzj.decoration.view.IHomeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class HomePresenter implements IHomePresenter{

    private IHomeView mHomeView;
    private IHomeModel mHomeModel;
    private final CompositeDisposable mCompositeDisposable;
    private Activity mActivity;

    public HomePresenter(IHomeView homeView) {
        mHomeView = homeView;
        mHomeModel = new HomeModel();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void setActivity(MainActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public DelegateAdapter initRecyclerView(RecyclerView recyclerView) {
        //初始化
        //创建VirtualLayoutManager对象
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);

        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        //设置适配器
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        recyclerView.setAdapter(delegateAdapter);
        return delegateAdapter;
    }

    @Override
    public BaseDelegateAdapter initBannerAdapter() {
        //TODO 需要实现获取Banner接口
        final List<Object> arrayList = mHomeModel.getBannerList();
        //banner
        return new BaseDelegateAdapter(mActivity, new LinearLayoutHelper(), R.layout.view_layout_banner, 1, Constant.VIEW_TYPE.BANNER) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                // 绑定数据
                Banner mBanner = holder.getView(R.id.home_banner);
                mHomeView.setBanner(mBanner,arrayList);
            }
        };
    }

    @Override
    public BaseDelegateAdapter initGvMenu() {
        //menu
        // 在构造函数设置每行的网格个数
        final TypedArray proPic = mActivity.getResources().obtainTypedArray(R.array.find_gv_image);
        final String[] proName = mActivity.getResources().getStringArray(R.array.find_gv_title);
        final List<Integer> images = new ArrayList<>();
        for(int i=0 ; i<proName.length ; i++){
            images.add(proPic.getResourceId(i,R.mipmap.ic_data_picture));
        }
        proPic.recycle();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setPadding(0, 16, 0, 16);
        gridLayoutHelper.setVGap(16);   // 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(0);    // 控制子元素之间的水平间距
        gridLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, gridLayoutHelper, R.layout.item_functionbtn_iv, 8, Constant.VIEW_TYPE.GRID) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                holder.setText(R.id.tv_new_seed_title, proName[position]);
                holder.setImageResource(R.id.iv_new_seed_ic, images.get(position));
                holder.getView(R.id.ll_new_seed_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mHomeView.setFunctionButtonOnClick(position);
                    }
                });
            }
        };
    }

    @Override
    public BaseDelegateAdapter initPopularBrand() {
        //menu
        // 在构造函数设置每行的网格个数
        final TypedArray proPic = mActivity.getResources().obtainTypedArray(R.array.data_narrow_Image);
        final List<Integer> images = new ArrayList<>();
        for(int i =0 ; i<proPic.length() ; i++){
            images.add(proPic.getResourceId(i,R.mipmap.ic_data_picture));
        }
        proPic.recycle();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        gridLayoutHelper.setPadding(0, 5, 0, 5);
        gridLayoutHelper.setVGap(5);   // 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(0);    // 控制子元素之间的水平间距
        gridLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, gridLayoutHelper, R.layout.item_popular_brand_iv, 6, Constant.VIEW_TYPE.GRID) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                holder.setImageResource(R.id.iv_popular_brand_ic, images.get(position));
                holder.getView(R.id.ll_popular_brand_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mHomeView.setPopularBrandItemOnClick(position);
                    }
                });
            }
        };
    }


    @Override
    public BaseDelegateAdapter initTitle(final String title) {
        return new BaseDelegateAdapter(mActivity, new LinearLayoutHelper(), R.layout.view_vlayout_title, 1, Constant.VIEW_TYPE.TITLE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                holder.setText(R.id.tv_title, title);
            }
        };
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
}
