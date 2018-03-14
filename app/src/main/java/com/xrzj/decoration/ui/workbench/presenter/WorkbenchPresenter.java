package com.xrzj.decoration.ui.workbench.presenter;

import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.ui.workbench.contract.WorkbenchContract;

/**
 * @author: zhoufu
 * @date: On 2018/3/14
 */

public class WorkbenchPresenter extends BaseRxPresenter<WorkbenchContract.View> implements WorkbenchContract.Presenter{


    public WorkbenchPresenter(WorkbenchContract.View view) {
        super(view);
    }
}
