package com.xrzj.decoration.test.test2;

import com.xrzj.decoration.model.IModel;

import java.util.HashMap;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public class TestPresenter2 implements ITestPresenter2{
    private ITest2View mITest2View;
    private ITestModel2 mITestModel2;

    public TestPresenter2(Test2Acticity view) {
        this.mITest2View = view;
        mITestModel2 = new Test2Model();
    }


    @Override
    public void search(HashMap<String, String> map) {
        mITestModel2.search(map, new IModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                mITest2View.showData((String)success);
            }

            @Override
            public void OnFialded(Object error) {
                mITest2View.showErro();
            }
        });

    }
}
