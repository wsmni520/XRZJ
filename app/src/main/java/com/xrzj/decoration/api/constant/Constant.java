package com.xrzj.decoration.api.constant;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class Constant {

    public interface VIEW_TYPE{
        //轮播图
        int BANNER = 1;
        //九宫格
        int GRID = 2;
        //标题
        int TITLE = 3;
        //list
        int LIST = 4;
        //新闻
        int NEWS = 5;
        //跑马灯
        int MARQUEE = 6;
        //不规则视图
        int PLUS = 7 ;
        //指示器
        int STICKY = 8;
        //底部
        int FOOTER = 9;
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
