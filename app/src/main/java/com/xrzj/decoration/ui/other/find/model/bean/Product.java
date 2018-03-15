package com.xrzj.decoration.ui.other.find.model.bean;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class Product {
    //作品名称
    private String productName;
    //作品房屋面积
    private String productHouseArea;
    //作品户型
    private String productHouseType;
    //作品风格
    private String productHouseStyle;


    public Product(String productName, String productHouseArea, String productHouseType, String productHouseStyle) {
        this.productName = productName;
        this.productHouseArea = productHouseArea;
        this.productHouseType = productHouseType;
        this.productHouseStyle = productHouseStyle;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductHouseArea() {
        return productHouseArea;
    }

    public void setProductHouseArea(String productHouseArea) {
        this.productHouseArea = productHouseArea;
    }

    public String getProductHouseType() {
        return productHouseType;
    }

    public void setProductHouseType(String productHouseType) {
        this.productHouseType = productHouseType;
    }

    public String getProductHouseStyle() {
        return productHouseStyle;
    }

    public void setProductHouseStyle(String productHouseStyle) {
        this.productHouseStyle = productHouseStyle;
    }
}


