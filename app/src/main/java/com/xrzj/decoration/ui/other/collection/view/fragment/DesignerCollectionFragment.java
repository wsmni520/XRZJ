package com.xrzj.decoration.ui.other.collection.view.fragment;


import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.fragment.BaseFragment;
import com.xrzj.decoration.ui.other.collection.adapter.DesignerCollectionListAdapter;
import com.xrzj.decoration.ui.other.collection.contract.DesignerCollectContract;
import com.xrzj.decoration.ui.other.collection.presenter.DesignerCollectionPresenter;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.widget.DefaultItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DesignerCollectionFragment extends BaseFragment<DesignerCollectContract.Presenter> implements DesignerCollectContract.View {

    @BindView(R.id.swipe_menu_recycler_view)
    SwipeMenuRecyclerView mSwipeMenuRecyclerView;

    private List<Designer> mDesigner = new ArrayList<>();
    private DesignerCollectionListAdapter mDesignerCollectionListAdapter;

    @Override
    public int getContentView() {
        return R.layout.designer_collection_fragment;
    }

    @Override
    public void initView() {
        Log.d("DesignerCollection", "initView");
        initDesignerCollectionSwipeMenuRecyclerView();
    }

    private void initDesignerCollectionSwipeMenuRecyclerView() {
        Log.d("DesignerCollection", "initDesignerCollectionSwipeMenuRecyclerView");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        mSwipeMenuRecyclerView.setLayoutManager(linearLayoutManager);
        mSwipeMenuRecyclerView.addItemDecoration(new DefaultItemDecoration(ContextCompat.getColor(getContext(), R.color.divider_color)));


        mSwipeMenuRecyclerView.setSwipeItemClickListener(mItemClickListener);

        // 设置菜单创建器。
        mSwipeMenuRecyclerView.setSwipeMenuCreator(swipeMenuCreator());
        mSwipeMenuRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);
        // 实例化Adapter对象
        mDesignerCollectionListAdapter = new DesignerCollectionListAdapter(mDesigner);
        mSwipeMenuRecyclerView.setAdapter(mDesignerCollectionListAdapter);
    }


    /**
     * RecyclerView的Item点击监听。
     */
    private SwipeItemClickListener mItemClickListener = new SwipeItemClickListener() {
        @Override
        public void onItemClick(View itemView, int position) {
            Toast.makeText(getContext(), "第" + position + "个", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * RecyclerView的Item中的Menu点击监听。
     */
    private SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            menuBridge.closeMenu();
            // 左侧还是右侧菜单
            int direction = menuBridge.getDirection();
            // RecyclerView的Item的position
            int adapterPosition = menuBridge.getAdapterPosition();
            // 菜单在RecyclerView的Item中的Position
            int menuPosition = menuBridge.getPosition();

            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                Toast.makeText(getContext(), "删除list第" + adapterPosition + "; 右侧菜单第" + menuPosition, Toast.LENGTH_SHORT).show();
                deleteDesignerCollectionByPosition(adapterPosition);
                mDesignerCollectionListAdapter.notifyDataSetChanged();
            }
        }
    };

    private void deleteDesignerCollectionByPosition(int position) {
        List<Designer> newDesignerCollection = new ArrayList<>();
        for(int i=0;i<mDesigner.size();i++){
            if(i!=position){
                newDesignerCollection.add(mDesigner.get(i));
            }
        }
        mDesigner.clear();
        mDesigner.addAll(newDesignerCollection);

    }


    private SwipeMenuCreator swipeMenuCreator() {
        /**
         * 菜单创建器。在Item要创建菜单的时候调用。
         */
        return new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
                int width = getResources().getDimensionPixelSize(R.dimen.dp_70);

                // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
                // 2. 指定具体的高，比如80;
                // 3. WRAP_CONTENT，自身高度，不推荐;
                int height = ViewGroup.LayoutParams.MATCH_PARENT;
                SwipeMenuItem deleteItem = new SwipeMenuItem(mContext)
                        .setBackgroundColorResource(R.color.red)
                        // 文字
                        .setText("删除")
                        // 文字颜色
                        .setTextColor(Color.WHITE)
                        // 文字大小
                        .setTextSize(16)
                        .setWidth(width)
                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                // 添加一个按钮到右侧侧菜单
                swipeRightMenu.addMenuItem(deleteItem);
            }
        };
    }

    @Override
    public void initData() {
        mPresenter.getDesignerCollectionList();
    }

    @Override
    public void initListener() {

    }

    @Override
    public DesignerCollectContract.Presenter initPresenter() {
        return new DesignerCollectionPresenter(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }

    @Override
    public void showDesignerCollectionList(List<Designer> designers) {
        Log.d("DesignerCollection", "showDesignerCollectionList()");
        mDesigner.addAll(designers);
        mDesignerCollectionListAdapter.notifyDataSetChanged();
    }
}
