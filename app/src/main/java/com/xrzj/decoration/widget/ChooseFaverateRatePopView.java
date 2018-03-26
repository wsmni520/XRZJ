package com.xrzj.decoration.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.xrzj.decoration.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * @author: zhoufu
 * @date: On 2018/3/26
 */

public class ChooseFaverateRatePopView extends BasePopupWindow{

    public ChooseFaverateRatePopView(Context context) {
        super(context, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setAutoLocatePopup(true);
    }

    public ChooseFaverateRatePopView(Context context, int w, int h) {
        super(context, w, h);
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
        return LayoutInflater.from(getContext()).inflate(R.layout.drop_down_faverate_rate_pop_layout, null);
    }

    @Override
    public View initAnimaView() {
        return null;
    }
}
