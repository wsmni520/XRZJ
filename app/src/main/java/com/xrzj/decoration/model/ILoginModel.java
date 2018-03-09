package com.xrzj.decoration.model;

/**
 * @author: zhoufu
 * @date: On 2018/3/9
 */

public interface ILoginModel extends IModel{
    boolean checkUser(String userName,String userPwd,AsyncCallback callback);
}
