package com.xrzj.decoration.api.constant;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class Constant {

    public interface VIEW_TYPE{
        //轮播图
        int BANNER = 1;
        //功能按钮
        int FUNCTION_BTN = 2;
        //标题栏
        int TITLE_BAR = 3;
        //装修相关
        int DECORATIONRELEVANT = 4;
        //效果图
        int RENDERINGS = 5;
        //跑马灯
        int MARQUEE = 6;
        //装修大学
        int DECORATIONUV = 7 ;
        //热门品牌
        int POPULAR_BRAND = 8;
        //休闲娱乐
        int ENTERTAINMENT = 9;
    }

    public interface ENTER_TYPE{
        String TYPE = "TYPE";
        //没选择类型
        int NONE_TYPE = -1;
        //设计师
        int DESIGNER = 1;
        //监理
        int SUPERVISOR = 2;
        //工地主管
        int SCENE_MANAGER = 3;
        //施工人员
        int WORKER = 4;
        //材料商
        int MATERIAL_PROVIDER = 5;
    }
}
