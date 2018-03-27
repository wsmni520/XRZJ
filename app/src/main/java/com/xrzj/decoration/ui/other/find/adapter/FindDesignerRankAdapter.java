package com.xrzj.decoration.ui.other.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;
import com.xrzj.decoration.ui.other.find.model.bean.DesignerHotVO;
import com.xrzj.decoration.widget.HeadPhotoStatusView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class FindDesignerRankAdapter extends BaseRecyclerViewAdapter<FindDesignerRankAdapter.ViewHolder> {

    private final Context mContext;
    private List<DesignerHotVO> mDesigners;


    public FindDesignerRankAdapter(Context context,List<DesignerHotVO> designers) {
        this.mDesigners = designers;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_designer_rank_recycler_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mDesigners.get(position).getPicture()).into(holder.mDesignerPhotoIv);
        holder.mDesignerNameTv.setText(mDesigners.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDesigners == null ? 0 : mDesigners.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.designer_photo_iv)
        HeadPhotoStatusView mDesignerPhotoIv;
        @BindView(R.id.designer_name_tv)
        TextView mDesignerNameTv;

        ViewHolder(View itemView, final FindDesignerRankAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mDesignerPhotoIv.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    adapter.onItemHolderClick(ViewHolder.this);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.onItemHolderClick(ViewHolder.this);
                }
            });
        }
    }
}
