package com.xrzj.decoration.view;

import com.youth.banner.Banner;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public interface IHomeView{
    //设置轮播图
    void setBanner(Banner mBanner, List<Object> arrayList);
    void setFunctionButtonOnClick(int position);
    void setPopularBrandItemOnClick(int position);

}
