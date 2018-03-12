package com.xrzj.decoration.ui.other.designer.presenter;

import android.app.Activity;
import android.util.Log;

import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.ui.other.designer.contract.FindDesignerContract;
import com.xrzj.decoration.ui.other.designer.model.IFindDesignerModel;
import com.xrzj.decoration.ui.other.designer.model.bean.Designer;
import com.xrzj.decoration.ui.other.designer.model.impl.FindDesignerModel;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/12
 */

public class FindDesignerPresenterImpl extends BaseRxPresenter<FindDesignerContract.View> implements FindDesignerContract.Presenter {

    private IFindDesignerModel mFindDesignerModel;
    private Activity mActivity;



    public FindDesignerPresenterImpl(FindDesignerContract.View view) {
        super(view);
        this.mFindDesignerModel = new FindDesignerModel();
    }

    @Override
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void getDesignerList() {
        Log.d("FindDesignerPresenter","getDesignerList");
        mFindDesignerModel.getDesinerList(new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                Log.d("FindDesignerPresenter","OnSuccessed");
                mView.showDesignerRankList((List<Designer>) success);
                mView.showDesignerList((List<Designer>) success);
                mView.dismissLoadingProgress();
            }

            @Override
            public void OnFialded(Object error) {
                mView.dismissLoadingProgress();
            }
        });
    }
}
