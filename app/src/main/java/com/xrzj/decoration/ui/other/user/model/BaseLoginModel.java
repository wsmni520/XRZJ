package com.xrzj.decoration.ui.other.user.model;

import com.xrzj.decoration.base.mvp.BaseModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public interface BaseLoginModel extends BaseModel {
    boolean checkUser(String userName,String userPwd,AsyncCallback callback);
}
