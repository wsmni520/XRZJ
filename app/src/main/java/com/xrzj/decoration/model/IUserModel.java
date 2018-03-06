package com.xrzj.decoration.model;

import com.xrzj.decoration.entity.User;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public interface IUserModel extends IModel{
	/**
	 * user login
	 * @param loginame
	 * @param password
	 * @param callback
	 */
	public void login(String loginame, String password, AsyncCallback callback);

	/**
	 * regist a new user
	 * @param user
	 * @param callback
	 */
	public void regist(User user, AsyncCallback callback);
}
