package com.xrzj.decoration.ui.other.order.model;

import com.xrzj.decoration.base.mvp.BaseModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public interface IOrderManageModel extends BaseModel{
    void getDesinerOrderList(final AsyncCallback callBack);
}
