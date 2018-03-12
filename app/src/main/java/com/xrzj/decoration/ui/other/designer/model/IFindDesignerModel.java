package com.xrzj.decoration.ui.other.designer.model;

import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.ui.other.designer.model.bean.Designer;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public interface IFindDesignerModel extends BaseModel{
    List<Designer> getDesinerList(final AsyncCallback callBack);
}
