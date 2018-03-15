package com.xrzj.decoration.ui.other.find.model.bean;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class Designer {
    //设计师等级
    private String rank;
    //人气
    private String popularity;
    //设计师名
    private String name;
    //设计年限
    private String designYear;
    //收藏数量
    private String collectionNum;
    //作品数量
    private String productNum;
    //成交数量
    private String transactionsNum;
    //预约数量
    private String orderNum;
    //好评率
    private String favorableRate;
    //设计费
    private String designPrice;
    //作品
    private Product product;

    public Designer(String rank, String popularity,
                    String name, String designYear,
                    String collectionNum, String productNum,
                    String transactionsNum, String orderNum,
                    String favorableRate, String designPrice, Product product) {
        this.rank = rank;
        this.popularity = popularity;
        this.name = name;
        this.designYear = designYear;
        this.collectionNum = collectionNum;
        this.productNum = productNum;
        this.transactionsNum = transactionsNum;
        this.orderNum = orderNum;
        this.favorableRate = favorableRate;
        this.designPrice = designPrice;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDesignYear() {
        return designYear;
    }

    public void setDesignYear(String designYear) {
        this.designYear = designYear;
    }

    public String getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(String collectionNum) {
        this.collectionNum = collectionNum;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getTransactionsNum() {
        return transactionsNum;
    }

    public void setTransactionsNum(String transactionsNum) {
        this.transactionsNum = transactionsNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getFavorableRate() {
        return favorableRate;
    }

    public void setFavorableRate(String favorableRate) {
        this.favorableRate = favorableRate;
    }

    public String getDesignPrice() {
        return designPrice;
    }

    public void setDesignPrice(String designPrice) {
        this.designPrice = designPrice;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
