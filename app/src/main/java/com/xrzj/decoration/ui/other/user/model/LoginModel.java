package com.xrzj.decoration.ui.other.user.model;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class LoginModel implements BaseLoginModel {
    @Override
    public boolean checkUser(String userName, String userPwd,AsyncCallback callback) {
        callback.OnSuccessed("111");
        return true;
    }
}
