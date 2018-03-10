package com.xrzj.decoration.ztest.test2;

import com.xrzj.decoration.base.mvp.BaseModel;

import java.util.HashMap;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public interface BaseTestModel2 extends BaseModel {
    public void search (HashMap<String,String> map, final AsyncCallback callBack);
}
