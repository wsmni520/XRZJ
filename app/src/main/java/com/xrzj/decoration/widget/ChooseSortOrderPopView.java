package com.xrzj.decoration.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.xrzj.decoration.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * @author: zhoufu
 * @date: On 2018/3/26
 */

public class ChooseSortOrderPopView extends BasePopupWindow implements View.OnClickListener {

    private View mPopupView;

    public ChooseSortOrderPopView(Context context) {
        super(context);
        bindEvent();
    }

    @Override
    protected Animation initShowAnimation() {
        return getDefaultAlphaAnimation();
    }


    @Override
    public View getClickToDismissView() {
        return null;
    }

    @Override
    public View onCreatePopupView() {
        mPopupView = LayoutInflater.from(getContext()).inflate(R.layout.from_bottom_sort_pop_layout, null);
        return mPopupView;
    }

    @Override
    public View initAnimaView() {
        return null;
    }

    private void bindEvent() {
        if (mPopupView != null) {
            mPopupView.findViewById(R.id.sort_by_default).setOnClickListener(this);
            mPopupView.findViewById(R.id.sort_by_designer_rank_asc).setOnClickListener(this);
            mPopupView.findViewById(R.id.sort_by_designer_rank_dec).setOnClickListener(this);
            mPopupView.findViewById(R.id.sort_by_faverate_rate_asc).setOnClickListener(this);
            mPopupView.findViewById(R.id.sort_by_faverate_rate_dec).setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //默认排序
            case R.id.sort_by_default:
                Toast.makeText(getContext(), "0", Toast.LENGTH_SHORT).show();
                break;
            //等级从低到高排序
            case R.id.sort_by_designer_rank_asc:
                Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
                break;
            //等级从高到低排序
            case R.id.sort_by_designer_rank_dec:
                Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                break;
            //好评率从低到高排序
            case R.id.sort_by_faverate_rate_asc:
                Toast.makeText(getContext(), "4", Toast.LENGTH_SHORT).show();
                break;
            //好评率从高到低排序
            case R.id.sort_by_faverate_rate_dec:
                Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
        this.dismiss();

    }
}
