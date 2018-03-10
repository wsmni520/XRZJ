package com.xrzj.decoration.ui.other.user.contract;

import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;

/**
 * @author: zhoufu
 * @date: On 2018/3/10
 */

public interface LoginContract {
    interface View extends BaseView {
        public void loginSuccess();

        public void loginFailed(String errorMessage);
    }

    interface Presenter extends BasePresenter {

        /**
         * login
         *
         * @param loginname
         * @param password
         */
        public void login(String loginname, String password);
    }
}
