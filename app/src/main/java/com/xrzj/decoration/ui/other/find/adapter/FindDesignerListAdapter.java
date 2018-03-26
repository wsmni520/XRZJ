package com.xrzj.decoration.ui.other.find.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.adapter.BaseRecyclerViewAdapter;
import com.xrzj.decoration.ui.home.model.Bean.Renderings;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;
import com.xrzj.decoration.utils.AppUtils;
import com.xrzj.decoration.widget.CircleImageView;
import com.xrzj.decoration.widget.SpaceItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class FindDesignerListAdapter extends BaseRecyclerViewAdapter<FindDesignerListAdapter.ViewHolder> {

    private List<Designer> mDesigners;
    private List<Renderings> mRenderings;
    private final Context mContext;

    public FindDesignerListAdapter(Context context, List<Renderings> renderings, List<Designer> designers) {
        this.mDesigners = designers;
        this.mContext = context;
        this.mRenderings = renderings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_designer_info_recycler_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Designer designer = mDesigners.get(position);
        holder.mDesignerPhotoIv.setImageResource(R.mipmap.bg_small_leaves_min);
        holder.mDesignerNameTv.setText(designer.getName());
        //        holder.mDesignerIdentificationIv.setImageResource(R.mipmap.me_icon_shezhi2x);
        //        holder.mDesignerSafeguardsIv.setImageResource(R.mipmap.me_icon_shezhi2x);
        //        holder.mDesignerRank.setText(designer.getRank());
        //        holder.mDesignerPerPrice.setText(designer.getDesignPrice());
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

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.designer_photo_iv)
        CircleImageView mDesignerPhotoIv;
        @BindView(R.id.level_iv)
        ImageView mLevelIv;
        @BindView(R.id.designer_name_tv)
        TextView mDesignerNameTv;
        @BindView(R.id.designer_identification_iv)
        TextView mDesignerIdentificationIv;
        @BindView(R.id.designer_safeguards_iv)
        TextView mDesignerSafeguardsIv;
        @BindView(R.id.designer_per_price_tv)
        TextView mDesignerPerPriceTv;
        @BindView(R.id.design_year)
        TextView mDesignYear;
        @BindView(R.id.design_favorable_rate_tv)
        TextView mDesignFavorableRateTv;
        @BindView(R.id.design_product_num_tv)
        TextView mDesignProductNumTv;
        @BindView(R.id.designer_transactions_num_tv)
        TextView mDesignerTransactionsNumTv;
        @BindView(R.id.designer_order_num_tv)
        TextView mDesignerOrderNumTv;
        @BindView(R.id.designer_collection)
        TextView mDesignerCollection;
        @BindView(R.id.design_rederings_recycler)
        RecyclerView mDesignRederingsRecycler;

        ViewHolder(View itemView, final FindDesignerListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mDesignRederingsRecycler.setLayoutManager(linearLayoutManager);
            mDesignRederingsRecycler.addItemDecoration(new SpaceItemDecoration(AppUtils.dip2px(mContext,16),AppUtils.dip2px(mContext,10)));
            FindDesignerRederingsListAdapter findDesignerRederingsListAdapter = new FindDesignerRederingsListAdapter(mContext, mRenderings);
            mDesignRederingsRecycler.setAdapter(findDesignerRederingsListAdapter);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.onItemHolderClick(ViewHolder.this);
                }
            });
            findDesignerRederingsListAdapter.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position) {
                                case 0:
                                    Toast.makeText(mContext, "设计图1", Toast.LENGTH_SHORT).show();
                                    break;
                                case 1:
                                    Toast.makeText(mContext, "设计图2", Toast.LENGTH_SHORT).show();
                                    break;
                                case 2:
                                    Toast.makeText(mContext, "设计图3", Toast.LENGTH_SHORT).show();
                                    break;
                                case 3:
                                    Toast.makeText(mContext, "设计图4", Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
            );
        }
    }
}
