package com.xrzj.decoration.ztest.test1;


import com.xrzj.decoration.base.mvp.BaseModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public interface BaseTestModel extends BaseModel {
    public void search (String ip,final AsyncCallback callBack);
    public void getpublicKey (final AsyncCallback callBack);
    public void gettoken (String key,final AsyncCallback callBack);
}
