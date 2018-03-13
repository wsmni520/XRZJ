package com.xrzj.decoration.ui.other.order.view.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.fragment.BaseFragment;
import com.xrzj.decoration.ui.other.order.adapter.DesignerOrderListAdapter;
import com.xrzj.decoration.ui.other.order.contract.DesignerOrderManageContract;
import com.xrzj.decoration.ui.other.order.contract.OrderManageContract;
import com.xrzj.decoration.ui.other.order.model.bean.Order;
import com.xrzj.decoration.ui.other.order.presenter.DesignerOrderManagePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesignerOrderFragment extends BaseFragment<DesignerOrderManageContract.Presenter> implements DesignerOrderManageContract.View {

    @BindView(R.id.designer_order_manage_recycler)
    RecyclerView mDesignerOrderManageRecycler;

    private DesignerOrderListAdapter mDesignerOrderListAdapter;
    private List<Order> mDesignerOrder = new ArrayList<>();

    @Override
    public int getContentView() {
        return R.layout.fragment_designer_order;
    }

    @Override
    public void initView() {
        //初始化设计师订单的Recycler
        initDesignerOrderRecycler();
    }

    private void initDesignerOrderRecycler() {
        mDesignerOrderListAdapter = new DesignerOrderListAdapter(mDesignerOrder);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        mDesignerOrderManageRecycler.setLayoutManager(linearLayoutManager);
        mDesignerOrderManageRecycler.setAdapter(mDesignerOrderListAdapter);

    }

    @Override
    public void initData() {
        mPresenter.getDesignerOrderList();
    }

    @Override
    public void initListener() {

    }

    @Override
    public DesignerOrderManageContract.Presenter initPresenter() {
        return new DesignerOrderManagePresenter(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }


    @Override
    public void showDesignerOrderList(List<Order> designerOrder) {
        mDesignerOrder.addAll(designerOrder);
        mDesignerOrderListAdapter.notifyDataSetChanged();
    }
}