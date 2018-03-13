package com.xrzj.decoration.ui.other.order.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;
import com.xrzj.decoration.ui.other.order.model.bean.Order;
import com.xrzj.decoration.widget.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public class DesignerOrderListAdapter extends BaseRecyclerViewAdapter<DesignerOrderListAdapter.ViewHolder> {

    private List<Order> mOrders;

    public DesignerOrderListAdapter(List<Order> orders) {
        this.mOrders = orders;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.designer_order_manage_recycler_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mDesignerNameTv.setText(mOrders.get(position).getDesignerOrder().getDesignerName());
        holder.mDesignerPhotoIv.setImageResource(R.mipmap.bg_small_magnolia_trees_min);
        holder.mOrderNum.setText(mOrders.get(position).getOrderNum());
        holder.mOrderName.setText(mOrders.get(position).getDesignerOrder().getOrderDescribe());
        holder.mProjectLocation.setText(mOrders.get(position).getDesignerOrder().getProjectLocation());
        holder.mProjectArea.setText(mOrders.get(position).getDesignerOrder().getArea());
        holder.mOrderState.setText(mOrders.get(position).getOrderState());
    }

    @Override
    public int getItemCount() {
        return mOrders == null ? 0 : mOrders.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.designer_photo_iv)
        CircleImageView mDesignerPhotoIv;
        @BindView(R.id.designer_name_tv)
        TextView mDesignerNameTv;
        @BindView(R.id.order_num)
        TextView mOrderNum;
        @BindView(R.id.order_name)
        TextView mOrderName;
        @BindView(R.id.project_location)
        TextView mProjectLocation;
        @BindView(R.id.project_area)
        TextView mProjectArea;
        @BindView(R.id.order_state)
        TextView mOrderState;

        ViewHolder(View itemView, final DesignerOrderListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.onItemHolderClick(ViewHolder.this);
                }
            });
        }
    }
}
