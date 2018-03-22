package com.xrzj.decoration.ui.home.model;

import com.xrzj.decoration.R;
import com.xrzj.decoration.ui.home.model.Bean.Renderings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class HomeModel implements IHomeModel{
    @Override
    public List<Object> getBannerList() {
        List<Object> mBannerImags = new ArrayList<>();
        mBannerImags.add(R.mipmap.banner1);
        mBannerImags.add(R.mipmap.banner2);
        mBannerImags.add(R.mipmap.banner3);
//        mBannerImags
//                .add("http://c.hiphotos.baidu.com/image/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=4d9580fd7b310a55db24d3f4877e20db/43a7d933c895d14317e8fe2d71f082025aaf0725.jpg");
//        mBannerImags
//                .add("http://f.hiphotos.baidu.com/image/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=0664044d9045d688bc02bfa494f91e6c/7e3e6709c93d70cffe5e6773fadcd100baa12b2c.jpg");
//        mBannerImags
//                .add("http://c.hiphotos.baidu.com/image/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=35fce30599504fc2bd5fbd05d5e68463/caef76094b36acaf340ff9f17ed98d1000e99ccb.jpg");
//        mBannerImags
//                .add("http://e.hiphotos.baidu.com/image/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=35418a60544e9258b9348beeacb9b22a/b58f8c5494eef01f064b7ac1e2fe9925bc317d52.jpg");
        return mBannerImags;
    }

    @Override
    public List<Renderings> getRenderingsList() {
        List<Renderings> renderings = new ArrayList<>();
        renderings.add(new Renderings("复地东湖国际","135","三室三厅","法式风格","13000"));
        renderings.add(new Renderings("万达御湖世家","145","四室两厅","中式风格","11100"));
        renderings.add(new Renderings("百瑞景","115","三室一厅","地中海风格","9000"));
        renderings.add(new Renderings("纯水岸东湖","125","三室两厅","现代风格","8000"));
        return renderings;
    }
}
