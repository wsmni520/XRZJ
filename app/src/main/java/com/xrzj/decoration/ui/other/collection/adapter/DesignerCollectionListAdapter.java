package com.xrzj.decoration.ui.other.collection.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;
import com.xrzj.decoration.widget.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public class DesignerCollectionListAdapter extends BaseRecyclerViewAdapter<DesignerCollectionListAdapter.ViewHolder> {
    private List<Designer> mDesigners;

    public DesignerCollectionListAdapter(List<Designer> Designers) {
        this.mDesigners = Designers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.designer_collection_recycler_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Designer designer = mDesigners.get(position);
        holder.mDesignerPhotoIv.setImageResource(R.mipmap.bg_small_leaves_min);
        holder.mDesignerNameTv.setText(designer.getName());
        holder.mDesignerIdentificationIv.setImageResource(R.mipmap.me_icon_shezhi2x);
        holder.mDesignerSafeguardsIv.setImageResource(R.mipmap.me_icon_shezhi2x);
        holder.mDesignerRank.setText(designer.getRank());
        holder.mDesignerPerPrice.setText(designer.getDesignPrice());
        holder.mDesignYear.setText(designer.getDesignYear());
        holder.mDesignerCollection.setText(designer.getCollectionNum());
        holder.mDesignProductNumTv.setText(designer.getProductNum());
        holder.mDesignerTransactionsNumTv.setText(designer.getTransactionsNum());
        holder.mDesignerOrderNumTv.setText(designer.getOrderNum());
        holder.mDesignFavorableRateTv.setText(designer.getFavorableRate());
    }

    @Override
    public int getItemCount() {
        return mDesigners == null ? 0 : mDesigners.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.designer_photo_iv)
        CircleImageView mDesignerPhotoIv;
        @BindView(R.id.designer_name_tv)
        TextView mDesignerNameTv;
        @BindView(R.id.designer_identification_tv)
        ImageView mDesignerIdentificationIv;
        @BindView(R.id.designer_Safeguards_iv)
        ImageView mDesignerSafeguardsIv;
        @BindView(R.id.designer_rank)
        TextView mDesignerRank;
        @BindView(R.id.designer_per_price)
        TextView mDesignerPerPrice;
        @BindView(R.id.design_year)
        TextView mDesignYear;
        @BindView(R.id.designer_collection)
        TextView mDesignerCollection;
        @BindView(R.id.design_product_num_tv)
        TextView mDesignProductNumTv;
        @BindView(R.id.designer_transactions_num_tv)
        TextView mDesignerTransactionsNumTv;
        @BindView(R.id.designer_order_num_tv)
        TextView mDesignerOrderNumTv;
        @BindView(R.id.design_favorable_rate_tv)
        TextView mDesignFavorableRateTv;
        private List<Designer> mDesigners;

        ViewHolder(View itemView, final DesignerCollectionListAdapter adapter) {
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
