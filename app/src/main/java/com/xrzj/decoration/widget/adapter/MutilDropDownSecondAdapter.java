package com.xrzj.decoration.widget.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/24
 */

public class MutilDropDownSecondAdapter extends BaseRecyclerViewAdapter<MutilDropDownSecondAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mProvinces;

    public MutilDropDownSecondAdapter(Context context,List<String> provinces) {
        this.mProvinces = provinces;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mutil_drop_down_recycler_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mAreaTv.setText(mProvinces.get(position));
    }

    @Override
    public int getItemCount() {
        return mProvinces == null ? 0 : mProvinces.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.area_tv)
        TextView mAreaTv;

        ViewHolder(View itemView, final MutilDropDownSecondAdapter adapter) {
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
