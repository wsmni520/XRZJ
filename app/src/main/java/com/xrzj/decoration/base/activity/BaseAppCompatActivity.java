package com.xrzj.decoration.base.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.xrzj.decoration.base.app.AppManager;
import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;

import butterknife.ButterKnife;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public abstract class BaseAppCompatActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView,View.OnClickListener{
    protected P mPresenter;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        //避免切换横竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.mContext = this;
        //将当前Activity添加到容器
        mPresenter = initPresenter();
        AppManager.getAppManager().addActivity(this);
        initView();
        initListener();
        initData();

//        context在Application中初始化
//        if(!NetworkUtils.isConnected()){
//            ToastUtils.showShort("请检查网络是否连接");
//        }
    }

    @Override
    protected void onDestroy() {
        //测试内存泄漏，正式一定要隐藏
        initLeakCanary();
        //将当前Activity移除到容器
        AppManager.getAppManager().removeActivity(this);
        //在presenter中解绑释放view
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
        //AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    /**
     * 返回一个用于显示界面的布局id
     * @return          视图id
     */
    public abstract int getContentView();

    /** 初始化View的代码写在这个方法中 */
    public abstract void initView();

    /** 初始化监听器的代码写在这个方法中 */
    public abstract void initListener();

    /** 初始数据的代码写在这个方法中，用于从服务器获取数据 */
    public abstract void    initData();
    /**
     * 在子类中初始化对应的presenter
     */
    public abstract P initPresenter();


    /**
     * 沉浸式状态栏
     */
    protected void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            // 隐藏状态栏
            //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // 隐藏状态栏
        }
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 用来检测所有Activity的内存泄漏
     */
    private void initLeakCanary() {
        /*RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
        refWatcher.watch(this);*/
    }

}
