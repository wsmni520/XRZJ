package com.xrzj.decoration.ui.home.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.xrzj.decoration.R;
import com.xrzj.decoration.api.constant.Constant;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.base.viewholder.BaseViewHolder;
import com.xrzj.decoration.ui.home.adapter.RenderingsAdapter;
import com.xrzj.decoration.ui.home.contract.HomeContract;
import com.xrzj.decoration.ui.home.model.Bean.Renderings;
import com.xrzj.decoration.ui.home.model.HomeModel;
import com.xrzj.decoration.ui.home.model.IHomeModel;
import com.xrzj.decoration.utils.AppUtils;
import com.xrzj.decoration.widget.MarqueeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class HomePresenter extends BaseRxPresenter<HomeContract.View> implements HomeContract.Presenter {

    private IHomeModel mHomeModel;
    private Activity mActivity;


    public HomePresenter(HomeContract.View homeView) {
        super(homeView);
        mHomeModel = new HomeModel();
    }

    @Override
    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    /**
     * 初始化显示主界面内容的RecyclerView
     *
     * @param recyclerView
     * @return
     */
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

    /**
     * 初始化主界面Banner板块
     *
     * @return
     */
    @Override
    public BaseDelegateAdapter initBannerAdapter() {
        //TODO 需要实现获取Banner接口
        final List<Object> arrayList = mHomeModel.getBannerList();
        //banner
        return new BaseDelegateAdapter(mActivity, new LinearLayoutHelper(), R.layout.home_banner_layout_, 1, Constant.VIEW_TYPE.BANNER) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                // 绑定数据
                Banner mBanner = holder.getView(R.id.home_banner);
                mView.setBanner(mBanner, arrayList);
            }
        };
    }

    /**
     * 初始化主界面功能按钮板块
     *
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initGvMenuColumn() {
        //menu
        // 在构造函数设置每行的网格个数
        final TypedArray proPic = mActivity.getResources().obtainTypedArray(R.array.find_gv_image);
        final String[] proName = mActivity.getResources().getStringArray(R.array.find_gv_title);
        final List<Integer> images = new ArrayList<>();
        for (int i = 0; i < proName.length; i++) {
            images.add(proPic.getResourceId(i, R.mipmap.ic_data_picture));
        }
        proPic.recycle();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setPadding(0, AppUtils.dip2px(mActivity, 10), 0, AppUtils.dip2px(mActivity, 10));
        // 控制子元素之间的垂直间距
        gridLayoutHelper.setVGap(AppUtils.dip2px(mActivity, 13));
        // 控制子元素之间的水平间距
        gridLayoutHelper.setHGap(0);
        gridLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, gridLayoutHelper, R.layout.home_functionbtn_vlayout_item, 8, Constant.VIEW_TYPE.FUNCTION_BTN) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                TextView functTv = holder.getView(R.id.func_btn_title);
                ImageView funcIv = holder.getView(R.id.home_func_item_iv);
                functTv.setText(proName[position]);
                funcIv.setImageResource(images.get(position));
                holder.getView(R.id.ll_new_seed_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mView.setFunctionButtonOnClick(position);
                    }
                });
            }
        };
    }

    /**
     * 初始化主界面热门品牌板块
     *
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initPopularBrandColumn() {
        //menu
        // 在构造函数设置每行的网格个数
        final TypedArray proPic = mActivity.getResources().obtainTypedArray(R.array.popularbrand_image);
        final List<Integer> images = new ArrayList<>();
        for (int i = 0; i < proPic.length(); i++) {
            images.add(proPic.getResourceId(i, R.mipmap.ic_data_picture));
        }
        proPic.recycle();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        gridLayoutHelper.setPadding(AppUtils.dip2px(mActivity, 11),
                0,
                AppUtils.dip2px(mActivity, 11),
                0);
        // 控制子元素之间的垂直间距
        gridLayoutHelper.setVGap(AppUtils.dip2px(mActivity, 6));
        // 控制子元素之间的水平间距
        gridLayoutHelper.setHGap(AppUtils.dip2px(mActivity, 6));
        gridLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, gridLayoutHelper, R.layout.home_popular_brand_vlayout_item, 9, Constant.VIEW_TYPE.POPULAR_BRAND) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                ImageView popularBrandIv = holder.getView(R.id.iv_popular_brand_ic);
                popularBrandIv.setImageResource(images.get(position));
                popularBrandIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mView.setPopularBrandItemOnClick(position);
                    }
                });
            }
        };
    }


    /**
     * 主界面标题板块
     *
     * @param title    标题名
     * @param maginTop 距离上一个板块的间距
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initTitle(final String title, final int maginTop) {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setMarginTop(AppUtils.dip2px(mActivity, maginTop));
        return new BaseDelegateAdapter(mActivity, linearLayoutHelper, R.layout.home_title_vlayout_item, 1, Constant.VIEW_TYPE.TITLE_BAR) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                TextView titleTv = holder.getView(R.id.tv_title);
                titleTv.setText(title);
            }
        };
    }

    /**
     * 主界面跑马灯板块
     *
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initMarqueeViewColumn() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        return new BaseDelegateAdapter(mActivity, linearLayoutHelper, R.layout.home_marquee_vlayout_item, 1, Constant.VIEW_TYPE.MARQUEE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                MarqueeView marqueeView = holder.getView(R.id.marqueeView);

                List<String> info1 = new ArrayList<>();
                info1.add("装修又要涨价了");
                info1.add("装修又要涨价了");
                marqueeView.startWithList(info1);
                // 在代码里设置自己的动画
                marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        mView.setMarqueeClick(position);
                    }
                });
            }
        };
    }


    /**
     * 主界面休闲娱乐板块
     *
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initEntertainmentColumn() {
        // 在构造函数设置每行的网格个数
        final TypedArray proPic = mActivity.getResources().obtainTypedArray(R.array.entertainment_image);
        final List<Integer> images = new ArrayList<>();
        for (int i = 0; i < proPic.length(); i++) {
            images.add(proPic.getResourceId(i, R.mipmap.ic_data_picture));
        }
        proPic.recycle();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setPadding(AppUtils.dip2px(mActivity, 11),
                0,
                AppUtils.dip2px(mActivity, 11),
                AppUtils.dip2px(mActivity, 15));
        // 控制子元素之间的垂直间距
        gridLayoutHelper.setVGap(AppUtils.dip2px(mActivity, 6));
        // 控制子元素之间的水平间距
        gridLayoutHelper.setHGap(AppUtils.dip2px(mActivity, 6));
        gridLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, gridLayoutHelper, R.layout.home_entertainment_vlayout_item, 4, Constant.VIEW_TYPE.ENTERTAINMENT) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                ImageView entertainmentItemIv = holder.getView(R.id.entertainment_item_msv);
                entertainmentItemIv.setImageResource(images.get(position));
                entertainmentItemIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mView.setEntertainmentClick(position);
                    }
                });

            }
        };
    }


    /**
     * 装修相关 计算器，特色团购，新手指引
     * 一拖二样式
     *
     * @param maginTop 顶部间距
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initDecorationRelevantColumn(final int maginTop) {
        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();
        //设置布局底部与下个布局的间隔
        onePlusNLayoutHelper.setItemCount(3);
        onePlusNLayoutHelper.setMarginTop(AppUtils.dip2px(mActivity, maginTop));
        onePlusNLayoutHelper.setBgColor(Color.WHITE);
        // 在构造函数设置每行的网格个数
        final TypedArray proPic = mActivity.getResources().obtainTypedArray(R.array.compute);
        final List<Integer> images = new ArrayList<>();
        for (int i = 0; i < proPic.length(); i++) {
            images.add(proPic.getResourceId(i, R.mipmap.ic_data_picture));
        }
        proPic.recycle();
        return new BaseDelegateAdapter(mActivity, onePlusNLayoutHelper, R.layout.home_compute_vlayout_item, 3, Constant.VIEW_TYPE.DECORATIONRELEVANT) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                ImageView decorationRelevantIv = holder.getView(R.id.one_plus_two);
                decorationRelevantIv.setImageResource(images.get(position));
                decorationRelevantIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mView.setPopularBrandItemOnClick(position);
                    }
                });

            }
        };
    }

    /**
     * 初始化装修大学板块
     *
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initDecorationUvColumn() {
        final TypedArray proPic = mActivity.getResources().obtainTypedArray(R.array.decoration_uv);
        final List<Integer> images = new ArrayList<>();
        for (int i = 0; i < proPic.length(); i++) {
            images.add(proPic.getResourceId(i, R.mipmap.ic_data_picture));
        }
        proPic.recycle();
        //设置线性布局
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置Item个数
        linearLayoutHelper.setItemCount(2);
        //设置间隔高度
        linearLayoutHelper.setBgColor(Color.WHITE);
        linearLayoutHelper.setDividerHeight(AppUtils.dip2px(mActivity, 10));
        return new BaseDelegateAdapter(mActivity, linearLayoutHelper, R.layout.home_decoration_university_vlayout_item, 2, Constant.VIEW_TYPE.DECORATIONUV) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                ImageView decorationUvIv = holder.getView(R.id.decoration_uv_iv);
                decorationUvIv.setImageResource(images.get(position));
                decorationUvIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mView.setDecorationUvItemClick(position);
                    }
                });

            }
        };
    }

    /**
     * 初始化装修效果图模块
     *
     * @return BaseDelegateAdapter
     */
    @Override
    public BaseDelegateAdapter initRenderingsColumn() {
        Log.d("Renderings","initRenderingsColumn");

        //设置线性布局
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置Item个数
        linearLayoutHelper.setItemCount(1);
        linearLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, linearLayoutHelper, R.layout.home_renderings_vlayout_item, 1, Constant.VIEW_TYPE.RENDERINGS) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                RecyclerView renderingsRecycler = holder.getView(R.id.renderings_recycler);
                List<Renderings> renderingsList = mHomeModel.getRenderingsList();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                renderingsRecycler.setLayoutManager(linearLayoutManager);
                RenderingsAdapter renderingsAdapter = new RenderingsAdapter(renderingsList,mActivity);
                renderingsRecycler.setAdapter(renderingsAdapter);
                renderingsAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mView.setrenderingsItemClick(position);
                    }
                });
            }
        };
    }


}
