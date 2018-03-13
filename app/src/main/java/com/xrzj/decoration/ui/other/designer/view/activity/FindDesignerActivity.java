package com.xrzj.decoration.ui.other.designer.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.base.app.AppManager;
import com.xrzj.decoration.ui.other.designer.adapter.FindDesignerListAdapter;
import com.xrzj.decoration.ui.other.designer.adapter.FindDesignerRankAdapter;
import com.xrzj.decoration.ui.other.designer.contract.FindDesignerContract;
import com.xrzj.decoration.ui.other.designer.model.bean.Designer;
import com.xrzj.decoration.ui.other.designer.presenter.FindDesignerPresenterImpl;
import com.xrzj.decoration.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FindDesignerActivity extends BaseAppCompatActivity<FindDesignerContract.Presenter> implements FindDesignerContract.View{

    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.title_right_pre_iv)
    ImageView mTitleRightPreIv;
    @BindView(R.id.title_right_last_iv)
    ImageView mTitleRightLastIv;
    @BindView(R.id.designer_rank_recycler)
    RecyclerView mDesignerRankRecycler;
    @BindView(R.id.find_designer_recycler)
    RecyclerView mFindDesignerRecycler;

    private List<Designer> mDesigner = new ArrayList<>();
    private FindDesignerRankAdapter mFindDesignerRankAdapter;
    private FindDesignerListAdapter mFindDesignerListAdapter;

    private static final String TAG = "FindDesignerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d(TAG,"onCreate");
        mPresenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        LogUtils.d(TAG,"onDestroy");
        super.onDestroy();
        mPresenter.unSubscribe();
    }

    @Override
    public int getContentView() {
        return R.layout.find_designer_layout;
    }

    @Override
    public void initView() {
        LogUtils.d(TAG,"initView");
        mTvTitle.setText(R.string.find_designer_title);
        //初始化设计师排行的Recycler
        initDesignerRankRecycler();
        //初始化设计师列表的Recycler
        initDesignerListRecycler();
        //初始化下拉列表
        initSpinnerList();

    }

    private void initDesignerListRecycler() {
        LogUtils.d(TAG,"initDesignerListRecycler");
        mFindDesignerListAdapter = new FindDesignerListAdapter(mDesigner);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mFindDesignerRecycler.setLayoutManager(linearLayoutManager);
        mFindDesignerRecycler.setAdapter(mFindDesignerListAdapter);

    }

    /**
     * 初始化设计师排行的Recycler
     */
    private void initDesignerRankRecycler() {
        LogUtils.d(TAG,"initDesignerRankRecycler");
        mFindDesignerRankAdapter = new FindDesignerRankAdapter(mDesigner);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mDesignerRankRecycler.setLayoutManager(linearLayoutManager);
        mDesignerRankRecycler.setAdapter(mFindDesignerRankAdapter);
    }

    @Override
    public void initListener() {
        LogUtils.d(TAG,"initListener");
        //初始化设计师排行榜item点击
        initDesignerRankItemClickListener();
        initDesignerItemClickListener();
    }

    private void initDesignerItemClickListener() {
        mFindDesignerListAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"选择的是第"+position+"位设计师",Toast.LENGTH_SHORT).show();
                startActivity(DesignerActivity.class);
            }
        });

    }

    /**
     * 初始化设计师排行榜item点击
     */
    private void initDesignerRankItemClickListener() {
        LogUtils.d(TAG,"initDesignerRankItemClickListener");
        mFindDesignerRankAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"选择的是第"+position+"位设计师",Toast.LENGTH_SHORT).show();
                startActivity(DesignerActivity.class);
            }
        });
    }

    @Override
    public void initData() {

        LogUtils.d(TAG,"initData");
        mPresenter.getDesignerList();

    }

    private void initSpinnerList() {


    }

    @Override
    public FindDesignerContract.Presenter initPresenter() {
        LogUtils.d(TAG,"initPresenter");
        return new FindDesignerPresenterImpl(this);
    }

    @Override
    @OnClick({R.id.btnBack, R.id.title_right_pre_iv, R.id.title_right_last_iv})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                AppManager.getAppManager().finishActivity();
                break;
            case R.id.title_right_pre_iv:
                Toast.makeText(this,"find",Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_right_last_iv:
                Toast.makeText(this,"wenhao",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoadingProgress(String msg) {
        LogUtils.d(TAG,"showLoadingProgress");

    }

    @Override
    public void dismissLoadingProgress() {
        LogUtils.d(TAG,"dismissLoadingProgress");

    }

    @Override
    public void showDesignerRankList(List<Designer> designerList) {
        LogUtils.d(TAG,"showDesignerRankList");
        //这里不能使用mDesigner = designerList；
        mDesigner.addAll(designerList);
        mFindDesignerRankAdapter.notifyDataSetChanged();

    }

    @Override
    public void showDesignerList(List<Designer> designerList) {
        mDesigner.addAll(designerList);
        mFindDesignerListAdapter.notifyDataSetChanged();
        LogUtils.d(TAG,"showDesignerList");

    }
}
