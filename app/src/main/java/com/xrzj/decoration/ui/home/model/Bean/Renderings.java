package com.xrzj.decoration.ui.home.model.Bean;

/**
 * @author: zhoufu
 * @date: On 2018/3/21
 */

public class Renderings {

    //作品名称
    private String productName;
    //作品房屋面积
    private String productHouseArea;
    //作品户型
    private String productHouseType;
    //作品风格
    private String productHouseStyle;

    private String faverateNum;

    public Renderings(String productName, String productHouseArea, String productHouseType, String productHouseStyle, String faverateNum) {
        this.productName = productName;
        this.productHouseArea = productHouseArea;
        this.productHouseType = productHouseType;
        this.productHouseStyle = productHouseStyle;
        this.faverateNum = faverateNum;
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

    public String getFaverateNum() {
        return faverateNum;
    }

    public void setFaverateNum(String faverateNum) {
        this.faverateNum = faverateNum;
    }
}
