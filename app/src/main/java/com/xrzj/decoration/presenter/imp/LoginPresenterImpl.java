package com.xrzj.decoration.presenter.imp;


import com.xrzj.decoration.model.ILoginModel;
import com.xrzj.decoration.model.IModel;
import com.xrzj.decoration.model.imp.LoginModel;
import com.xrzj.decoration.presenter.ILoginPresenter;
import com.xrzj.decoration.view.ILoginView;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class LoginPresenterImpl implements ILoginPresenter {

	private ILoginModel mLoginModel;
	private ILoginView mLoginView;

	public LoginPresenterImpl(ILoginView loginView) {
		this.mLoginView = loginView;
		this.mLoginModel = new LoginModel();
	}

	/**
	 *
	 * @param loginname
	 * @param password
	 */
	@Override
	public void login(String loginname, String password) {
		mLoginModel.checkUser(loginname, password, new IModel.AsyncCallback() {
			@Override
			public void OnSuccessed(Object success) {
				mLoginView.loginSuccess();
			}

			@Override
			public void OnFialded(Object error) {

			}
		});
	}

	@Override
	public void subscribe() {

	}

	@Override
	public void unSubscribe() {

	}
}
