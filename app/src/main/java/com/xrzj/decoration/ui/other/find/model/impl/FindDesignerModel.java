package com.xrzj.decoration.ui.other.find.model.impl;

import android.util.Log;

import com.xrzj.decoration.ui.home.model.Bean.Renderings;
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

    @Override
    public List<Designer> getDesginerRankList() {
        List<Designer> designers = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Designer designer = new Designer("lv11", "9999",
                    "张三", "设计年限10年",
                    "收藏122", "作品28",
                    "成交10", "30人已预约",
                    "好评率", "50/㎡", new Product("慵懒时刻", "120㎡","三室两厅", "中式"));
            designers.add(designer);
        }
        Log.d("FindDesignerModel","designers size = " + designers.size());
        return designers;
    }

    @Override
    public List<Designer> getDesginerList() {
        List<Designer> designers = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Designer designer = new Designer("lv11", "9999",
                    "张三", "设计年限10年",
                    "收藏122", "作品28",
                    "成交10", "30人已预约",
                    "好评率", "50/㎡", new Product("慵懒时刻", "120㎡","三室两厅", "中式"));
            designers.add(designer);
        }
        Log.d("FindDesignerModel","designers size = " + designers.size());
        return designers;
    }

    @Override
    public List<Renderings> getDesginerRederingsReList() {
        List<Renderings> renderings = new ArrayList<>();
        renderings.add(new Renderings("复地东湖国际","135","三室三厅","法式风格","13000"));
        renderings.add(new Renderings("万达御湖世家","145","四室两厅","中式风格","11100"));
        renderings.add(new Renderings("百瑞景","115","三室一厅","地中海风格","9000"));
        renderings.add(new Renderings("纯水岸东湖","125","三室两厅","现代风格","8000"));
        return renderings;
    }
}
