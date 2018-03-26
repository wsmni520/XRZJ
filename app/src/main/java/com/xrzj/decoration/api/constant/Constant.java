package com.xrzj.decoration.api.constant;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class Constant {

    public interface VIEW_TYPE{
        //轮播图
        int BANNER = 1;
        //分栏1
        int GRID_TWO = 2;
        //分栏2
        int GRID_THREE = 3;
        //分栏3
        int GRID_FOUR = 4;
        //标题栏
        int TITLE_BAR = 5;
        //一拖二
        int ONE_PLUS_TWO = 6;
        //自定义1
        int DEFINE_ONE = 7;
        //自定义2
        int DEFINE_TWO = 8;
        //跑马灯
        int MARQUEE_ONE = 9;
        //列表1
        int LIST_ONE = 10;
        //下拉框
        int DROP_DOWN_BOX = 11;
        //固定位置
        int Fixed_POSITION = 12;
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
