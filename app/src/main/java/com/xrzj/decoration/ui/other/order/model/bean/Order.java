package com.xrzj.decoration.ui.other.order.model.bean;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public class Order {

    private String orderState;
    private String orderType;
    private DesignerOrder designerOrder;
    private String orderNum;


    public Order(String orderState, String orderType, DesignerOrder designerOrder, String orderNum) {
        this.orderState = orderState;
        this.orderType = orderType;
        this.designerOrder = designerOrder;
        this.orderNum = orderNum;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public DesignerOrder getDesignerOrder() {
        return designerOrder;
    }

    public void setDesignerOrder(DesignerOrder designerOrder) {
        this.designerOrder = designerOrder;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
