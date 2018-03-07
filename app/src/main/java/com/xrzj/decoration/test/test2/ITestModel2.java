package com.xrzj.decoration.test.test2;

import com.xrzj.decoration.model.IModel;

import java.util.HashMap;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public interface ITestModel2 extends IModel{
    public void search (HashMap<String,String> map, final AsyncCallback callBack);
}
