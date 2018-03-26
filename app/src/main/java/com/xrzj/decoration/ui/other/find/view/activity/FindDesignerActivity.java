package com.xrzj.decoration.ui.other.find.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.blankj.utilcode.util.BarUtils;
import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.base.adapter.BaseDelegateAdapter;
import com.xrzj.decoration.base.app.AppManager;
import com.xrzj.decoration.ui.other.find.contract.FindDesignerContract;
import com.xrzj.decoration.ui.other.find.model.bean.ClassfiyBean;
import com.xrzj.decoration.ui.other.find.presenter.FindDesignerPresenter;
import com.xrzj.decoration.utils.AppUtils;
import com.xrzj.decoration.widget.ChooseDesignerRankPopView;
import com.xrzj.decoration.widget.ChooseFaverateRatePopView;
import com.xrzj.decoration.widget.ChooseSortOrderPopView;
import com.xrzj.decoration.widget.MutilDropDownListPopView;
import com.xrzj.decoration.widget.SearchToolBarPopView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class FindDesignerActivity extends BaseAppCompatActivity<FindDesignerContract.Presenter> implements FindDesignerContract.View {

    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.title_right_pre_iv)
    ImageView mTitleRightPreIv;
    @BindView(R.id.title_right_last_iv)
    ImageView mTitleRightLastIv;
    @BindView(R.id.find_designer_rank_recycler)
    RecyclerView mFindDesignerRecycler;

    private LinkedList<DelegateAdapter.Adapter> mAdapters;
    private static final String TAG = "FindDesignerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setSteepStatusBar(true);
        super.onCreate(savedInstanceState);
        mPresenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unSubscribe();
    }

    @Override
    public int getContentView() {
        return R.layout.find_designer_layout;
    }

    @Override
    public void initView() {
        mPresenter.setActivity(this);
        mAdapters = new LinkedList<>();
        initTitle();

        //初始化设计师排行的Recycler
        //        initDesignerRankRecycler();
        //初始化设计师列表的Recycler
        initFindDesignerListRecycler();

    }

    private void initTitle() {
        mTvTitle.setText(R.string.find_designer_title);
        mTitleRightPreIv.setImageResource(R.drawable.title_search_ic);
        mTitleRightLastIv.setImageResource(R.drawable.title_question_ic);
    }

    private void initFindDesignerListRecycler() {
        DelegateAdapter delegateAdapter = mPresenter.initRecyclerView(mFindDesignerRecycler);
        //设计师等级列表加入集合
        BaseDelegateAdapter designerRankAdapter = mPresenter.initDesignerRankListAdapter();
        mAdapters.add(designerRankAdapter);
        //下拉列表加入集合
        BaseDelegateAdapter dropBoxAdapter = mPresenter.initDropdownBoxAdapter();
        mAdapters.add(dropBoxAdapter);
        //设计师列表加入集合
        BaseDelegateAdapter designerListAdapter = mPresenter.initDesignerListAdapter();
        mAdapters.add(designerListAdapter);
        //设计师排序加入集合
        BaseDelegateAdapter designerSortAdapter= mPresenter.initDesignerListSortAdapter();
        mAdapters.add(designerSortAdapter);
        delegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
        mPresenter.getDesignerList();

    }

    @Override
    public FindDesignerContract.Presenter initPresenter() {
        return new FindDesignerPresenter(this);
    }


    @Override
    @OnClick({R.id.btnBack, R.id.title_right_pre_iv, R.id.title_right_last_iv})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                AppManager.getAppManager().finishActivity();
                break;
            case R.id.title_right_pre_iv:
                showSearchToolBar();
                break;
            case R.id.title_right_last_iv:
                Toast.makeText(this, "wenhao", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void showSearchToolBar() {
        SearchToolBarPopView searchToolBarPopView = new SearchToolBarPopView(mContext);
        searchToolBarPopView.setOffsetY(BarUtils.getStatusBarHeight(mContext));
        searchToolBarPopView.setAutoShowInputMethod(true);
        searchToolBarPopView.showPopupWindow();
    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }

    /**
     * 设计师排序点击事件
     */
    @Override
    public void setDesignerListOrderItemClick(View view) {
        ChooseSortOrderPopView chooseSortOrderPopView = new ChooseSortOrderPopView(mContext);
        chooseSortOrderPopView.setBlurBackgroundEnable(true);
//        chooseSortOrderPopView.setOnBeforeShowCallback(new BasePopupWindow.OnBeforeShowCallback() {
//            @Override
//            public boolean onBeforeShow(View popupRootView, View anchorView, boolean hasShowAnima) {
//                if (mSelectedView == null) {
//                    popup.setBlurBackgroundEnable(true);
//                } else {
//                    PopupBlurOption option = new PopupBlurOption();
//                    option.setBlurView(mSelectedView)
//                            .setFullScreen(false);
//                    popup.setBlurOption(option);
//                }
//                return true;
//            }
//        });
        chooseSortOrderPopView.showPopupWindow();
    }

    @Override
    public void setDesignerRankListItemClick(int position) {
        switch (position) {
            case 0:
                Toast.makeText(this, "设计师等级榜0", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "设计师等级榜1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "设计师等级榜2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "设计师等级榜3", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }



    @Override
    public void setDropdownBoxItemClick(View view) {
        switch ((String)view.getTag()) {
            case "service_area" :
                chooseDesignerServiceArea(view);
                break;
            case "designer_rank" :
                chooseDesignerRank(view);
                break;
            case "faverable_rate" :
                chooseFaverableRate(view);
                break;
            default :
                break;
        }
    }

    private void chooseDesignerRank(View view) {
        ChooseDesignerRankPopView chooseDesignerRankPopView = new ChooseDesignerRankPopView(mContext);
        chooseDesignerRankPopView.showPopupWindow(view);
    }

    private void chooseFaverableRate(View view) {
        ChooseFaverateRatePopView chooseFaverateRatePopView = new ChooseFaverateRatePopView(mContext);
        chooseFaverateRatePopView.showPopupWindow(view);
    }



    private void chooseDesignerServiceArea(View view) {
        final TextView text = view.findViewById(R.id.service_area_tv);
        List<ClassfiyBean> mClassfiyBeanList = new ArrayList<>();

        MutilDropDownListPopView pop = new MutilDropDownListPopView(mContext, mClassfiyBeanList, AppUtils.dip2px(mContext,345));
        DisplayMetrics metric = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;

        pop.setWidth(width);
        pop.setOnItemSelectedListener(new MutilDropDownListPopView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(String name) {
                Toast.makeText(mContext, "选择了区", Toast.LENGTH_SHORT).show();
                text.setText(name);
            }
        });
        pop.showAsDropDown(view);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });
    }

    @Override
    public void setDesignerListItemClick(int position) {
        switch (position) {
            case 0:
                Toast.makeText(this, "设计师0", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "设计师1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "设计师2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "设计师3", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
