package com.xrzj.decoration.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.widget.BasePopWindow;
import com.xrzj.decoration.ui.other.find.model.bean.ClassfiyBean;
import com.xrzj.decoration.widget.adapter.MutilDropDownFirstAdapter;
import com.xrzj.decoration.widget.adapter.MutilDropDownSecondAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 多级下拉列表
 */
public class MutilDropDownListPopView extends BasePopWindow {

    private List<ClassfiyBean> mClassfiyBeanList;
    private int mFirstPosition = -1;
    private int mSecondPosition = -1;
    private String mFirstKey;
    private String mSecondKey;
    private int mListMaxHeight;
    private RecyclerView mFirstDropDownList;
    private RecyclerView mSecondDropDownList;
    private MutilDropDownFirstAdapter mMutilDropDownFirstAdapter;
    private MutilDropDownSecondAdapter mMutilDropDownSecondAdapter;
    private OnItemSelectedListener onItemSelectedListener;

    public MutilDropDownListPopView(Context context, List<ClassfiyBean> classfiyBeanList, int listMaxHeight) {
        super(context);
        mClassfiyBeanList = classfiyBeanList;
        mListMaxHeight = listMaxHeight;
        dealDefaultKey();
        initView();
    }

    private void dealDefaultKey() {

    }

    private void initView() {
        final List<String> mProvinces = new ArrayList<>();
        mProvinces.add("武汉市");
        mFirstDropDownList = mView.findViewById(R.id.first_drop_down_recycler);
        //位置固定大小
        mFirstDropDownList.setHasFixedSize(true);
        mFirstDropDownList.setLayoutManager(new LinearLayoutManager(mContext));
        mMutilDropDownFirstAdapter= new MutilDropDownFirstAdapter(mContext,mProvinces);
        mMutilDropDownFirstAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedListener.onItemSelected(mProvinces.get(position));
                MutilDropDownListPopView.this.dismiss();
            }
        });
        mFirstDropDownList.setAdapter(mMutilDropDownFirstAdapter);

        final List<String> mRegion = new ArrayList<>();
        for(int i = 0;i<10;i++){
            mRegion.add("江汉区");
        }
        mSecondDropDownList = mView.findViewById(R.id.second_drop_down_recycler);
        mSecondDropDownList.setLayoutManager(new LinearLayoutManager(mContext));
        mMutilDropDownSecondAdapter= new MutilDropDownSecondAdapter(mContext,mRegion);
        mMutilDropDownSecondAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedListener.onItemSelected(mRegion.get(position));
                MutilDropDownListPopView.this.dismiss();
            }

        });
        mSecondDropDownList.setAdapter(mMutilDropDownSecondAdapter);

        //手动设置了最大高度
        if (mListMaxHeight > 0) {
            setListMaxHeight();
        }
        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //必须设置  ps:xml bg和这个不冲突
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //设置后  达到返回按钮先消失popupWindow
        this.setFocusable(true);
    }

    /**
     * 手动设置popwindow的高度
     */
    public void setListMaxHeight() {
        ViewGroup.LayoutParams FirstLayoutParams = mFirstDropDownList.getLayoutParams();
        ViewGroup.LayoutParams SecondLayoutParams = mSecondDropDownList.getLayoutParams();
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mFirstDropDownList.measure(widthMeasureSpec, heightMeasureSpec);
        mSecondDropDownList.measure(widthMeasureSpec, heightMeasureSpec);
        int FirstListHeight = mFirstDropDownList.getMeasuredHeight();
        int SecondListHeight = mSecondDropDownList.getMeasuredHeight();
        int maxHeight = Math.max(FirstListHeight, SecondListHeight);
        if (maxHeight > mListMaxHeight) {
            maxHeight = mListMaxHeight;
        }
        FirstLayoutParams.height = maxHeight;
        SecondLayoutParams.height = maxHeight;
        mFirstDropDownList.setLayoutParams(FirstLayoutParams);
        mSecondDropDownList.setLayoutParams(SecondLayoutParams);
    }

    @Override
    protected int setLayout() {
        return R.layout.drop_down_service_area_pop_layout;
    }

    public interface OnItemSelectedListener {
        void onItemSelected(String name);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }


}
