package com.xrzj.decoration.base.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * @author: zhoufu
 * @date: On 2018/3/24
 */

public abstract class BasePopWindow extends PopupWindow {

    protected Context mContext;
    protected View mView;

    public BasePopWindow(Context context) {
        super(context);
        mContext = context;
        initLayout(setLayout());
    }

    protected View initLayout(int layoutId) {
        mView = LayoutInflater.from(mContext).inflate(layoutId, null);
        return mView;
    }

    protected void setBackground(int colorId) {
        ColorDrawable dw = new ColorDrawable(ContextCompat.getColor(mContext, colorId));
        setBackgroundDrawable(dw);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    /**
     * 设置布局文件子类
     *
     * @return
     */
    protected abstract int setLayout();
}