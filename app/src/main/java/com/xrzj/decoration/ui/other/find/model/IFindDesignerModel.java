package com.xrzj.decoration.ui.other.find.model;

import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.ui.home.model.Bean.Renderings;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public interface IFindDesignerModel extends BaseModel{
    //Demo
    List<Designer> getDesinerList(final AsyncCallback callBack);
    List<Designer> getDesginerRankList();
    List<Designer> getDesginerList();
    List<Renderings> getDesginerRederingsReList();

    //------------------------------------------------------------//
    void getDesginerHotList(final AsyncCallback callBack);

}
