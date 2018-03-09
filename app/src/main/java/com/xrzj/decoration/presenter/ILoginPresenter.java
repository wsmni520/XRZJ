package com.xrzj.decoration.presenter;

import com.xrzj.decoration.base.BasePresenter;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public interface ILoginPresenter extends BasePresenter{

	/**
	 * login
	 * @param loginname
	 * @param password
	 */
	public void login(String loginname, String password);
}
