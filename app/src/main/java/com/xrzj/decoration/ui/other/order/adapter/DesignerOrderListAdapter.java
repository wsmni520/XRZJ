package com.xrzj.decoration.ui.other.order.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;
import com.xrzj.decoration.ui.other.order.model.bean.Order;
import com.xrzj.decoration.ui.other.order.view.activity.PayForOrderActivity;
import com.xrzj.decoration.widget.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public class DesignerOrderListAdapter extends BaseRecyclerViewAdapter<DesignerOrderListAdapter.ViewHolder> {


    private final int ORDER_STATE_PAY = 1;
    private final int ORDER_STATE_SURE = 2;
    private final int ORDER_STATE_WAIT = 3;
    private List<Order> mOrders;
    private Activity mActivity;

    public DesignerOrderListAdapter(Activity activity, List<Order> orders) {
        this.mOrders = orders;
        this.mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.designer_order_manage_recycler_item, parent, false);
        switch (viewType) {
            case ORDER_STATE_PAY :
                itemView.findViewById(R.id.check_order_btn).setVisibility(View.GONE);
                itemView.findViewById(R.id.appeal_order_btn).setVisibility(View.GONE);
                itemView.findViewById(R.id.evaluate_order_btn).setVisibility(View.GONE);
                itemView.findViewById(R.id.payfor_order_btn).setVisibility(View.VISIBLE);
                break;
            case ORDER_STATE_SURE :
                itemView.findViewById(R.id.check_order_btn).setVisibility(View.GONE);
                itemView.findViewById(R.id.appeal_order_btn).setVisibility(View.GONE);
                itemView.findViewById(R.id.evaluate_order_btn).setVisibility(View.GONE);
                itemView.findViewById(R.id.confirm_order_btn).setVisibility(View.VISIBLE);
                break;
            case ORDER_STATE_WAIT :
                break;
            default :
                break;
        }


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
    public int getItemViewType(int position) {
        Order order = mOrders.get(position);
        switch (order.getOrderState()) {
            case "pay":
                return ORDER_STATE_PAY;
            case "sure":
                return ORDER_STATE_SURE;
            case "wait":
                return ORDER_STATE_WAIT;
            default:
                return ORDER_STATE_WAIT;
        }
    }

    @Override
    public int getItemCount() {
        return mOrders == null ? 0 : mOrders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.check_order_btn)
        Button mCheckOrderBtn;
        @BindView(R.id.appeal_order_btn)
        Button mAppealOrderBtn;
        @BindView(R.id.evaluate_order_btn)
        Button mEvaluateOrderBtn;
        @BindView(R.id.payfor_order_btn)
        Button mPayforOrderBtn;
        @BindView(R.id.cancel_order_btn)
        Button mCancelOrderBtn;
        @BindView(R.id.confirm_order_btn)
        Button mConfirmOrderBtn;

        ViewHolder(View itemView, final DesignerOrderListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.onItemHolderClick(ViewHolder.this);
                }
            });

            mCheckOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("mCheckOrderBtn", "onClick");
                    Toast.makeText(mActivity, "查看", Toast.LENGTH_SHORT).show();
                }
            });

            mAppealOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("mCheckOrderBtn", "onClick");
                    Toast.makeText(mActivity, "申诉", Toast.LENGTH_SHORT).show();
                }
            });

            mEvaluateOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("mCheckOrderBtn", "onClick");
                    Toast.makeText(mActivity, "评价", Toast.LENGTH_SHORT).show();
                }
            });
            mPayforOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("mCheckOrderBtn", "onClick");
                    Intent intent = new Intent(mActivity, PayForOrderActivity.class);
                    mActivity.startActivity(intent);
                }
            });
            mConfirmOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("mCheckOrderBtn", "onClick");
                    Toast.makeText(mActivity, "确认订单", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
