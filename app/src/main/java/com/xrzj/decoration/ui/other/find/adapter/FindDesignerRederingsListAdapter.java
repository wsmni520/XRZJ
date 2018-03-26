package com.xrzj.decoration.ui.other.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;
import com.xrzj.decoration.ui.home.model.Bean.Renderings;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class FindDesignerRederingsListAdapter extends BaseRecyclerViewAdapter<FindDesignerRederingsListAdapter.ViewHolder> {

    private List<Renderings> mRenderings;
    private final Context mContext;

    public FindDesignerRederingsListAdapter(Context context, List<Renderings> renderings) {
        this.mRenderings = renderings;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_designer_renderings_recycler_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mDesignRederingsIv.setImageResource(R.mipmap.renderings_pic);
        holder.mStyle.setText("花样年华");
        String area_pattern = mContext.getResources().getString(R.string.area_pattern);
        String area = mRenderings.get(position).getProductHouseArea();
        String pattern = mRenderings.get(position).getProductHouseType();
        holder.mAreaPattern.setText(String.format(area_pattern,area,pattern));
    }

    @Override
    public int getItemCount() {
        return mRenderings == null ? 0 : mRenderings.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.design_rederings_iv)
        ImageView mDesignRederingsIv;
        @BindView(R.id.style)
        TextView mStyle;
        @BindView(R.id.area_pattern)
        TextView mAreaPattern;

        ViewHolder(View itemView, final FindDesignerRederingsListAdapter adapter) {
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
