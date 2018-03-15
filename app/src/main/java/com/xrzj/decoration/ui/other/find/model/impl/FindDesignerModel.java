package com.xrzj.decoration.ui.other.find.model.impl;

import android.util.Log;

import com.xrzj.decoration.ui.other.find.model.IFindDesignerModel;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;
import com.xrzj.decoration.ui.other.find.model.bean.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class FindDesignerModel implements IFindDesignerModel {
    @Override
    public List<Designer> getDesinerList(final AsyncCallback callBack) {

        List<Designer> designers = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Designer designer = new Designer("等级八", "人气9999",
                    "张三", "设计年限10年",
                    "收藏122", "作品28",
                    "成交10", "30人已预约",
                    "好评率", "50/㎡", new Product("慵懒时刻", "120㎡","三室两厅", "中式"));
            designers.add(designer);
        }
        Log.d("FindDesignerModel","designers size = " + designers.size());
        callBack.OnSuccessed(designers);
        return designers;
    }
}
