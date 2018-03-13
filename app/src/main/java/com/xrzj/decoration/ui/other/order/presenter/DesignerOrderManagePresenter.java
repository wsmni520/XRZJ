package com.xrzj.decoration.ui.other.order.presenter;

import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.ui.other.order.contract.DesignerOrderManageContract;
import com.xrzj.decoration.ui.other.order.model.IOrderManageModel;
import com.xrzj.decoration.ui.other.order.model.bean.Order;
import com.xrzj.decoration.ui.other.order.model.impl.OrderManageModel;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public class DesignerOrderManagePresenter extends BaseRxPresenter<DesignerOrderManageContract.View> implements DesignerOrderManageContract.Presenter {
    private IOrderManageModel mOrderManageModel;

    public DesignerOrderManagePresenter(DesignerOrderManageContract.View view) {
        super(view);
        mOrderManageModel = new OrderManageModel();
    }

    @Override
    public void getDesignerOrderList() {
        mOrderManageModel.getDesinerOrderList(new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                mView.showDesignerOrderList((List<Order>) success);
            }

            @Override
            public void OnFialded(Object error) {

            }
        });
    }
}
