package com.xrzj.decoration.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xrzj.decoration.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * @author: zhoufu
 * @date: On 2018/3/26
 */

public class SearchToolBarPopView extends BasePopupWindow implements View.OnClickListener {

    EditText mSearchEt;
    ImageView mClearInputIv;
    TextView mCancelTv;
    private View mSearchBarPop;

    public SearchToolBarPopView(Context context) {
        super(context, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setAutoLocatePopup(true);
        bindEvent();
    }

    private void bindEvent() {
        mSearchEt = mSearchBarPop.findViewById(R.id.search_et);
        mClearInputIv = mSearchBarPop.findViewById(R.id.clear_input_iv);
        mCancelTv = mSearchBarPop.findViewById(R.id.cancel_tv);
        mSearchEt.setOnClickListener(this);
        mClearInputIv.setOnClickListener(this);
        mCancelTv.setOnClickListener(this);
    }

    @Override
    public EditText getInputView() {
        return mSearchBarPop.findViewById(R.id.search_et);
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
        mSearchBarPop = LayoutInflater.from(getContext()).inflate(R.layout.top_search_pop_layout, null);
        return mSearchBarPop;
    }

    @Override
    public View initAnimaView() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_et:
                break;
            case R.id.clear_input_iv:
                mSearchEt.setText("");
                break;
            case R.id.cancel_tv:
                this.dismiss();
                break;
            default:
                break;
        }
    }
}
