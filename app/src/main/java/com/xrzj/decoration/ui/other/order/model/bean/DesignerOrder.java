package com.xrzj.decoration.ui.other.order.model.bean;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public class DesignerOrder {
    private String orderDescribe;
    private String designerName;
    private String projectLocation;
    private String area;

    public DesignerOrder(String orderDescribe, String designerName, String projectLocation, String area) {
        this.orderDescribe = orderDescribe;
        this.designerName = designerName;
        this.projectLocation = projectLocation;
        this.area = area;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
