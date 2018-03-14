package com.xrzj.decoration.ui.other.collection.model;

import com.xrzj.decoration.base.mvp.BaseModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/14
 */

public interface IDesignerCollectionModel extends BaseModel{
    void getDesignerCollectionList(AsyncCallback callBack);
}
