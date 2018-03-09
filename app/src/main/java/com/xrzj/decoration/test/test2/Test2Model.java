package com.xrzj.decoration.test.test2;

import android.util.Log;

import java.util.HashMap;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public class Test2Model implements ITestModel2{

    @Override
    public void search(HashMap<String, String> map, final AsyncCallback callBack) {
        Log.d("Test2Model","search");
    }
}
