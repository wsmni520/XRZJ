package com.xrzj.decoration.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author: zhoufu
 * @date: On 2018/3/26
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration{
    private int mFirstLeftDecoration;
    private int mLeftDecoration;
    private int mRightDecoration;
    private int mTopDecoration;
    private int mBottomDecoration;

    /**
     * Retrieve any offsets for the given item. Each field of <code>outRect</code> specifies
     * the number of pixels that the item view should be inset by, similar to padding or margin.
     * The default implementation sets the bounds of outRect to 0 and returns.
     * <p>
     * <p>
     * If this ItemDecoration does not affect the positioning of item views, it should set
     * all four fields of <code>outRect</code> (left, top, right, bottom) to zero
     * before returning.
     * <p>
     * <p>
     * If you need to access Adapter for additional data, you can call
     * {@link RecyclerView#getChildAdapterPosition(View)} to get the adapter position of the
     * View.
     *
     * @param outRect Rect to receive the output.
     * @param view    The child view to decorate
     * @param parent  RecyclerView this ItemDecoration is decorating
     * @param state   The current state of RecyclerView.
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = mRightDecoration;
        outRect.bottom = mBottomDecoration;
        outRect.top = mBottomDecoration;
        //设置第一个item 的做间距
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = mFirstLeftDecoration;
        }

    }

    public SpaceItemDecoration(int firstItemLeftDecoration, int rightDecoration) {
        this.mFirstLeftDecoration = firstItemLeftDecoration;
        this.mRightDecoration = rightDecoration;
    }
}

