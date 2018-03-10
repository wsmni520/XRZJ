package com.xrzj.decoration.ui.guide.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xrzj.decoration.R;
import com.xrzj.decoration.ui.guide.view.adapter.GuideViewPagerAdapter;
import com.xrzj.decoration.ui.other.user.view.activity.RegistActivity;
import com.xrzj.decoration.ui.other.user.view.activity.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class GuidActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "GuidActivity";

    @BindView(R.id.vp_guide)
    ViewPager mGuideVp;
    @BindView(R.id.ll_dots)
    LinearLayout mDotsLl;
    private List<View> mViews;
    private GuideViewPagerAdapter mGuideViewPagerAdapter;
    /**
     * 引导页图片布局资源
     */
    private int[] mGuidViews = {R.layout.guid_view1,
            R.layout.guid_view2, R.layout.guid_view3};
    /**
     * 底部小点图片
     */
    private ImageView[] mDots;
    /**
     * 记录当前选中位置
     */
    private int mCurrentIndex;
    private Button mLoginBtn;
    private Button mRegistBtn;
    private static final String LOGIN_TAG = "login";
    private static final String REGIST_TAG = "regist";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guid_activity);
        ButterKnife.bind(this);
        // 初始化引导页视图列表
        initGuidViews();

        setVpAdapter();
        setVpOnPageChangeListener();

    }

    private void setVpOnPageChangeListener() {
        mGuideVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCurDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= mGuidViews.length) {
            return;
        }
        mGuideVp.setCurrentItem(position);
    }

    /**
     * 设置当前指示点
     *
     * @param position
     */
    private void setCurDot(int position) {
        if (position < 0 || position > mGuidViews.length || mCurrentIndex == position) {
            return;
        }
        mDots[position].setEnabled(true);
        mDots[mCurrentIndex].setEnabled(false);
        mCurrentIndex = position;
    }

    private void setVpAdapter() {
        mGuideViewPagerAdapter = new GuideViewPagerAdapter(mViews);
        mGuideVp.setAdapter(mGuideViewPagerAdapter);
    }

    private void initGuidViews() {
        mViews = new ArrayList<View>();
        for (int i = 0; i < mGuidViews.length; i++) {
            View view = LayoutInflater.from(this).inflate(mGuidViews[i], null);

            if (i == mGuidViews.length - 1) {
                mLoginBtn = (Button) view.findViewById(R.id.btn_login);
                mLoginBtn.setTag(LOGIN_TAG);
                mLoginBtn.setOnClickListener(this);

                mRegistBtn = (Button) view.findViewById(R.id.btn_regist);
                mRegistBtn.setTag(REGIST_TAG);
                mRegistBtn.setOnClickListener(this);
            }
            mViews.add(view);
        }
        initdots();
    }

    private void initdots() {
        mDots = new ImageView[mGuidViews.length];
        //循环取得小点图片
        for (int i = 0; i < mGuidViews.length; i++) {
            // 得到一个LinearLayout下面的每一个子元素
            mDots[i] = (ImageView) mDotsLl.getChildAt(i);
            // 都设为灰色
            mDots[i].setEnabled(false);
            // 设置位置tag，方便取出与当前位置对应
            mDots[i].setTag(i);
        }
        mCurrentIndex = 0;
        // 设置为白色，即选中状态
        mDots[mCurrentIndex].setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"onclick -> tag : " + v.getTag());
        if (v.getTag().equals(LOGIN_TAG)) {
            enterLoginActivity();
            return;
        } else if (v.getTag().equals(REGIST_TAG)){
            enterRegistActivity();
            return;
        }
    }

    private void enterRegistActivity() {
        Intent intent = new Intent(this, RegistActivity.class);
        startActivity(intent);
        finish();
    }

    private void enterLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
