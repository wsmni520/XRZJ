package com.xrzj.decoration.model.imp;

import com.xrzj.decoration.model.ILoginModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public class LoginModel implements ILoginModel{
    @Override
    public boolean checkUser(String userName, String userPwd,AsyncCallback callback) {
        callback.OnSuccessed("111");
        return true;
    }
}
