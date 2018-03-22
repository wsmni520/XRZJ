package com.xrzj.decoration.ztest.test1;

import android.app.Activity;
import android.util.Log;

import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.utils.SharedPreferencesUtils;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public class TestPresenter implements ITestPresenter{


    private BaseTestModel mITestModel;
    private ITestView mITestView;
    private Activity mActivity;

    public TestPresenter(ITestView ITestView) {
        this.mITestView = ITestView;
        this.mITestModel = new TestModel();
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void search(String ip) {
        Log.d("TestPresenter2","search");
        mITestModel.search(ip, new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                mITestView.showData((TestBean) success);

            }

            @Override
            public void OnFialded(Object error) {
                mITestView.showErro();

            }
        });
    }

    @Override
    public void getpublicKey() {
        Log.d("TestPresenter2","search");
        mITestModel.getpublicKey(new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                mITestView.showKey((String) success);
            }

            @Override
            public void OnFialded(Object error) {
                mITestView.showErro();

            }
        });
    }

    @Override
    public void gettoken() {
        String key = SharedPreferencesUtils.getString(mActivity,"key");
        Log.d("TestPresenter2","gettoken  key= "+key);
        mITestModel.gettoken(key,new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                mITestView.showToken((String) success);
            }

            @Override
            public void OnFialded(Object error) {
                mITestView.showErro();

            }
        });

    }
}
