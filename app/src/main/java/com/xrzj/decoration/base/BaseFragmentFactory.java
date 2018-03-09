package com.xrzj.decoration.base;

import com.xrzj.decoration.ui.fragment.CommunicationFragment;
import com.xrzj.decoration.ui.fragment.HomeFragment;
import com.xrzj.decoration.ui.fragment.UserFragment;
import com.xrzj.decoration.ui.fragment.WorkbenchFragment;

/**
 * @author: zhoufu
 * @date: On 2018/3/8
 */

public class BaseFragmentFactory {

    private static BaseFragmentFactory mInstance;
    private HomeFragment mHomeFragment;
    private WorkbenchFragment mWorkbenchFragment;
    private CommunicationFragment mCommunicationFragment;
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


    public CommunicationFragment getCommunicationFragment() {
        if (mCommunicationFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mCommunicationFragment == null) {
                    mCommunicationFragment = new CommunicationFragment();
                }
            }
        }
        return mCommunicationFragment;
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
