package com.xrzj.decoration.base.fragment;

import com.xrzj.decoration.ui.message.view.fragment.MessageFragment;
import com.xrzj.decoration.ui.home.view.fragment.HomeFragment;
import com.xrzj.decoration.ui.other.user.view.fragment.UserFragment;
import com.xrzj.decoration.ui.workbench.view.fragment.WorkbenchFragment;

/**
 * @author: zhoufu
 * @date: On 2018/3/8
 */

public class BaseFragmentFactory {

    private static BaseFragmentFactory mInstance;
    private HomeFragment mHomeFragment;
    private WorkbenchFragment mWorkbenchFragment;
    private MessageFragment mMessageFragment;
    private UserFragment mUserFragment;

    private BaseFragmentFactory() {}

    public static BaseFragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new BaseFragmentFactory();
                }
            }
        }
        return mInstance;
    }


    public HomeFragment getHomeFragment() {
        if (mHomeFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
            }
        }
        return mHomeFragment;
    }


    public WorkbenchFragment getWorkbenchFragment() {
        if (mWorkbenchFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mWorkbenchFragment == null) {
                    mWorkbenchFragment = new WorkbenchFragment();
                }
            }
        }
        return mWorkbenchFragment;
    }


    public MessageFragment getMessageFragment() {
        if (mMessageFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                }
            }
        }
        return mMessageFragment;
    }


    public UserFragment getUserFragment() {
        if (mUserFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mUserFragment == null) {
                    mUserFragment = new UserFragment();
                }
            }
        }
        return mUserFragment;
    }

}
