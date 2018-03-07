package com.xrzj.decoration.test.test1;


import com.xrzj.decoration.model.IModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public interface ITestModel extends IModel{
    public void search (String ip,final AsyncCallback callBack);

}
