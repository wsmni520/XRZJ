package com.xrzj.decoration.ui.other.find.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.xrzj.decoration.R;
import com.xrzj.decoration.api.constant.Constant;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.base.viewholder.BaseViewHolder;
import com.xrzj.decoration.ui.home.model.Bean.Renderings;
import com.xrzj.decoration.ui.other.find.adapter.FindDesignerListAdapter;
import com.xrzj.decoration.ui.other.find.adapter.FindDesignerRankAdapter;
import com.xrzj.decoration.ui.other.find.contract.FindDesignerContract;
import com.xrzj.decoration.ui.other.find.model.IFindDesignerModel;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;
import com.xrzj.decoration.ui.other.find.model.bean.DesignerHotVO;
import com.xrzj.decoration.ui.other.find.model.impl.FindDesignerModel;
import com.xrzj.decoration.utils.AppUtils;
import com.xrzj.decoration.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class FindDesignerPresenter extends BaseRxPresenter<FindDesignerContract.View> implements FindDesignerContract.Presenter {

    private IFindDesignerModel mFindDesignerModel;
    private Activity mActivity;
    private RecyclerView mRecyclerView;
    private List<DesignerHotVO> mDesignersHotList;


    public FindDesignerPresenter(FindDesignerContract.View view) {
        super(view);
        this.mFindDesignerModel = new FindDesignerModel();
        mDesignersHotList = new ArrayList<>();
    }

    @Override
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void getDesignerList() {
        mFindDesignerModel.getDesinerList(new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                mView.dismissLoadingProgress();
            }

            @Override
            public void OnFialded(Object error) {
                mView.dismissLoadingProgress();
            }
        });
    }

    @Override
    public void getDesignerRankList() {

    }

    @Override
    public DelegateAdapter initRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        recyclerView.setAdapter(delegateAdapter);
        return delegateAdapter;
    }

    @Override
    public List<DesignerHotVO> getDesignerHotList() {
        Log.d("FindDesignerPresenter", "getDesignerHotList");
        mFindDesignerModel.getDesginerHotList(new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                if(success != null){
                    mDesignersHotList.addAll((List<DesignerHotVO>)success);
                }
                mDesignersRankAdapter.notifyDataSetChanged();
            }

            @Override
            public void OnFialded(Object error) {

            }
        });
        return mDesignersHotList;
    }
    private FindDesignerRankAdapter mDesignersRankAdapter;

    @Override
    public BaseDelegateAdapter initDesignerHotListAdapter() {

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        linearLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, linearLayoutHelper, R.layout.find_designer_rank_vlayout_item, 1, Constant.VIEW_TYPE.DEFINE_ONE) {



            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                RecyclerView designerRankRecycler = holder.getView(R.id.hot_designer_rank_recycler);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                designerRankRecycler.setLayoutManager(linearLayoutManager);
                designerRankRecycler.addItemDecoration(new SpaceItemDecoration(AppUtils.dip2px(mActivity,16),AppUtils.dip2px(mActivity,10)));

                mDesignersRankAdapter = new FindDesignerRankAdapter(mActivity,mDesignersHotList);
                designerRankRecycler.setAdapter(mDesignersRankAdapter);
                mDesignersRankAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mView.setDesignerRankListItemClick(position);
                    }
                });
            }
        };
    }

    @Override
    public BaseDelegateAdapter initDropdownBoxAdapter() {
        Log.d("Renderings", "initRenderingsColumn");
        //设置线性布局
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        //设置Item个数
        stickyLayoutHelper.setItemCount(1);
        stickyLayoutHelper.setBgColor(Color.WHITE);

        return new BaseDelegateAdapter(mActivity, stickyLayoutHelper, R.layout.find_designer_drop_down_vlayout_item, 1, Constant.VIEW_TYPE.DROP_DOWN_BOX) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.service_area_rl).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mRecyclerView !=null){
                            mRecyclerView.scrollToPosition(2);
                        }
                        v.setTag("service_area");
                        mView.setDropdownBoxItemClick(v);
                    }
                });
                holder.getView(R.id.designer_rank_rl).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mRecyclerView !=null){
                            mRecyclerView.scrollToPosition(2);
                        }
                        v.setTag("designer_rank");
                        mView.setDropdownBoxItemClick(v);
                    }
                });
                holder.getView(R.id.faverable_rate_rl).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mRecyclerView !=null){
                            mRecyclerView.scrollToPosition(2);
                        }
                        v.setTag("faverable_rate");
                        mView.setDropdownBoxItemClick(v);
                    }
                });


            }
        };
    }

    @Override
    public BaseDelegateAdapter initDesignerListSortAdapter() {
        FixLayoutHelper fixLayoutHelper = new FixLayoutHelper(FixLayoutHelper.BOTTOM_RIGHT,AppUtils.dip2px(mActivity,16),AppUtils.dip2px(mActivity,16));
        //设置Item个数
        return new BaseDelegateAdapter(mActivity, fixLayoutHelper, R.layout.find_sort_vlayout_item, 1, Constant.VIEW_TYPE.Fixed_POSITION) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.sort_by).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        mView.setDesignerListOrderItemClick(v);
                    }
                });
            }
        };
    }

    @Override
    public BaseDelegateAdapter initDesignerListAdapter() {
        Log.d("Renderings", "initRenderingsColumn");
        //设置线性布局
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);
        return new BaseDelegateAdapter(mActivity, linearLayoutHelper, R.layout.find_designer_info_vlayout_item, 1, Constant.VIEW_TYPE.DEFINE_TWO) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
                super.onBindViewHolder(holder, position);
                List<Designer> designersRank = mFindDesignerModel.getDesginerList();
                List<Renderings> designersRederings = mFindDesignerModel.getDesginerRederingsReList();

                RecyclerView designerListRecycler = holder.getView(R.id.design_rederings_recycler);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
                designerListRecycler.setLayoutManager(linearLayoutManager);

                FindDesignerListAdapter designersListAdapter = new FindDesignerListAdapter(mActivity, designersRederings, designersRank);
                designerListRecycler.setAdapter(designersListAdapter);
                designersListAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mView.setDesignerListItemClick(position);
                    }
                });
            }
        };


    }
}
