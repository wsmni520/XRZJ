package com.xrzj.decoration.ui.other.find.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class FindDesignerRankAdapter extends BaseRecyclerViewAdapter<FindDesignerRankAdapter.ViewHolder> {

    private List<Designer> mDesigners;

    public FindDesignerRankAdapter(List<Designer> designers) {
        this.mDesigners = designers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_designer_rank_recycler_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mDesignerPhotoIv.setImageResource(R.mipmap.bg_small_magnolia_trees_min);
        holder.mDesignerNameTv.setText(mDesigners.get(position).getName());
        holder.mDesignerPopularityTv.setText(mDesigners.get(position).getPopularity());
        holder.mDesignerRankTv.setText(mDesigners.get(position).getRank());
    }


    @Override
    public int getItemCount() {
        return mDesigners == null ? 0 : mDesigners.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.designer_photo_iv)
        ImageView mDesignerPhotoIv;
        @BindView(R.id.designer_name_tv)
        TextView mDesignerNameTv;
        @BindView(R.id.designer_popularity_tv)
        TextView mDesignerPopularityTv;
        @BindView(R.id.designer_rank_tv)
        TextView mDesignerRankTv;

        ViewHolder(View itemView, final FindDesignerRankAdapter adapter) {
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
