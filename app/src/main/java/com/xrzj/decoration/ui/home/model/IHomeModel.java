package com.xrzj.decoration.ui.home.model;

import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.ui.home.model.Bean.Renderings;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public interface IHomeModel extends BaseModel{
    List<Object> getBannerList();
    List<Renderings> getRenderingsList();
}
