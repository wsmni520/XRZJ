package com.xrzj.decoration.ui.other.user.presenter;


import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.ui.other.user.contract.LoginContract;
import com.xrzj.decoration.ui.other.user.model.BaseLoginModel;
import com.xrzj.decoration.ui.other.user.model.LoginModel;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public class LoginPresenterImpl extends BaseRxPresenter<LoginContract.View> implements LoginContract.Presenter {

	private BaseLoginModel mLoginModel;

	public LoginPresenterImpl(LoginContract.View loginView) {
		super(loginView);
		mLoginModel = new LoginModel();
	}

	/**
	 *
	 * @param loginname
	 * @param password
	 */
	@Override
	public void login(String loginname, String password) {
		mLoginModel.checkUser(loginname, password, new BaseModel.AsyncCallback() {
			@Override
			public void OnSuccessed(Object success) {
				mView.loginSuccess();
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
	public void unDisposable() {

	}
}
