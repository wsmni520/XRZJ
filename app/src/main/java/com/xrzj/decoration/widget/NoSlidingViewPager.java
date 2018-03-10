package com.xrzj.decoration.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 不能左右滑动的ViewPager
 * @author: zhoufu
 * @date: On 2018/3/8
 */
public class NoSlidingViewPager extends ViewPager {
    public NoSlidingViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}