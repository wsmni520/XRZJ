package com.xrzj.decoration.ui.other.collection.contract;

import com.xrzj.decoration.base.mvp.BasePresenter;
import com.xrzj.decoration.base.mvp.BaseView;
import com.xrzj.decoration.ui.other.find.model.bean.Designer;

import java.util.List;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

public interface DesignerCollectContract {
    interface View extends BaseView {
        void showDesignerCollectionList(List<Designer> designers);

    }
    interface Presenter extends BasePresenter {
        void getDesignerCollectionList();
    }

}

