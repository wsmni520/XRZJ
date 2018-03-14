package com.xrzj.decoration.ui.other.collection.model.impl;

import android.util.Log;

import com.xrzj.decoration.ui.other.collection.model.IDesignerCollectionModel;
import com.xrzj.decoration.ui.other.designer.model.bean.Designer;
import com.xrzj.decoration.ui.other.designer.model.bean.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/14
 */

public class DesignerCollectionModel implements IDesignerCollectionModel {
    @Override
    public void getDesignerCollectionList(final AsyncCallback callBack) {
        List<Designer> designers = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Designer designer = new Designer("等级八", "人气9999",
                    "张三"+i, "设计年限10年",
                    "收藏122", "作品28",
                    "成交10", "30人已预约",
                    "好评率", "50/㎡", new Product("慵懒时刻", "120㎡","三室两厅", "中式"));
            designers.add(designer);
        }
        Log.d("FindDesignerModel","designers size = " + designers.size());
        callBack.OnSuccessed(designers);
    }

}
