package com.xrzj.decoration.ui.other.collection.presenter;

import com.xrzj.decoration.base.mvp.BaseModel;
import com.xrzj.decoration.base.mvp.BaseRxPresenter;
import com.xrzj.decoration.ui.other.collection.contract.DesignerCollectContract;
import com.xrzj.decoration.ui.other.collection.model.IDesignerCollectionModel;
import com.xrzj.decoration.ui.other.collection.model.impl.DesignerCollectionModel;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/14
 */

public class DesignerCollectionPresenter extends BaseRxPresenter<DesignerCollectContract.View> implements DesignerCollectContract.Presenter{

    private final IDesignerCollectionModel mCollectionDesignerModel;

    public DesignerCollectionPresenter(DesignerCollectContract.View view) {
        super(view);
        mCollectionDesignerModel = new DesignerCollectionModel();
    }


    @Override
    public void getDesignerCollectionList() {
        mCollectionDesignerModel.getDesignerCollectionList(new BaseModel.AsyncCallback() {
            @Override
            public void OnSuccessed(Object success) {
                mView.showDesignerCollectionList((List<Designer>)success);
            }

            @Override
            public void OnFialded(Object error) {

            }
        });
    }
}
