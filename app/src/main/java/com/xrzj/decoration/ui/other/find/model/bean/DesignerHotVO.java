package com.xrzj.decoration.ui.other.find.model.bean;

/**
 * 设计师等级交互对象
 */
public class DesignerHotVO {

    /**
     * 设计师id
     */
    private String id;
    /**
     * 设计师姓名
     */
    private String name;
    /**
     * 设计师头像
     */
    private String picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "DesignerHotVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
