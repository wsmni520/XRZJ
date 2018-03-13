package com.xrzj.decoration.ui.other.order.contract;

import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;
import com.xrzj.decoration.ui.other.order.model.bean.Order;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public interface DesignerOrderManageContract {
    interface View extends BaseView {
        void showDesignerOrderList(List<Order> designerOrder);
    }

    interface Presenter extends BasePresenter {
        void getDesignerOrderList();
    }
}
