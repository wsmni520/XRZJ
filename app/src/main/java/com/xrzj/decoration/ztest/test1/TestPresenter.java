package com.xrzj.decoration.ztest.test1;

import android.util.Log;

import com.xrzj.decoration.base.mvp.BaseModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public class TestPresenter implements ITestPresenter{


    private BaseTestModel mITestModel;
    private ITestView mITestView;

    public TestPresenter(ITestView ITestView) {
        this.mITestView = ITestView;
        this.mITestModel = new TestModel();
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
}
