package com.xrzj.decoration.ui.other.order.model.impl;

import com.xrzj.decoration.ui.other.order.model.IOrderManageModel;
import com.xrzj.decoration.ui.other.order.model.bean.DesignerOrder;
import com.xrzj.decoration.ui.other.order.model.bean.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public class OrderManageModel implements IOrderManageModel {

    @Override
    public void getDesinerOrderList(AsyncCallback callBack) {
        List<Order> designerOrders = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Order designerOrder = new Order("等待确认",
                    "设计师订单",new DesignerOrder("3D家装设计","李胜男","项目位置：中北路","面积:121㎡"),"订单编号:yy9527");
            designerOrders.add(designerOrder);
        }
        callBack.OnSuccessed(designerOrders);
    }
}
