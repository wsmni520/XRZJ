package com.xrzj.decoration.ui.workbench.view.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.api.constant.Constant;
import com.xrzj.decoration.base.fragment.BaseFragment;
import com.xrzj.decoration.ui.other.collection.view.activity.MyCollectionActivity;
import com.xrzj.decoration.ui.other.enter.view.activity.EnterDesignerInputInfoActivity;
import com.xrzj.decoration.ui.other.order.view.activity.OrderManageActivity;
import com.xrzj.decoration.ui.workbench.contract.WorkbenchContract;
import com.xrzj.decoration.ui.workbench.presenter.WorkbenchPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class WorkbenchFragment extends BaseFragment<WorkbenchContract.Presenter> implements WorkbenchContract.View {


    @BindView(R.id.order_manage_ll)
    LinearLayout mOrderManageLl;
    @BindView(R.id.base_info_ll)
    LinearLayout mBaseInfoLl;
    @BindView(R.id.enter_ll)
    LinearLayout mEnterLl;
    @BindView(R.id.collection_ll)
    LinearLayout mCollectionLl;
    @BindView(R.id.case_manage_ll)
    LinearLayout mCaseManageLl;
    @BindView(R.id.service_help_ll)
    LinearLayout mServiceHelpLl;
    @BindView(R.id.to_do_list_ll)
    LinearLayout mToDoListLl;

    private boolean isDesigner = true;
    //需要在用户登录后重新确定入驻类型
    private int mEnterType = Constant.ENTER_TYPE.NONE_TYPE;

    @Override
    public int getContentView() {
        return R.layout.workbench_fragment;
    }

    @Override
    public void initView() {
        initBaseViewByUser();

    }

    private void showEnterTypeChooseDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.enter_dialog_item, null);
        Button nextBtn = (Button) view.findViewById(R.id.next);
        RadioGroup typeChooseRg = (RadioGroup)view.findViewById(R.id.enter_type_rg);
        //这里如果使用builer.setView(v)，自定义布局只会覆盖title和button之间的那部分
        final Dialog dialog = builder.create();
        dialog.show();
        //自定义布局应该在这里添加，要在dialog.show()的后面
        dialog.getWindow().setContentView(view);
        typeChooseRg.setOnCheckedChangeListener(new MyEnterTypeChooseListener());
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mEnterType) {
                    case Constant.ENTER_TYPE.DESIGNER :
                        Toast.makeText(mContext, "我是设计师", Toast.LENGTH_SHORT).show();
                        startActivity(EnterDesignerInputInfoActivity.class);
                        break;
                    case Constant.ENTER_TYPE.SUPERVISOR :
                        Toast.makeText(mContext, "我是监理", Toast.LENGTH_SHORT).show();
                        break;
                    case Constant.ENTER_TYPE.SCENE_MANAGER :
                        Toast.makeText(mContext, "我是工地主管", Toast.LENGTH_SHORT).show();
                        break;
                    case Constant.ENTER_TYPE.WORKER :
                        Toast.makeText(mContext, "我是施工人员", Toast.LENGTH_SHORT).show();
                        break;
                    case Constant.ENTER_TYPE.MATERIAL_PROVIDER :
                        Toast.makeText(mContext, "我是材料商", Toast.LENGTH_SHORT).show();
                        break;
                    case Constant.ENTER_TYPE.NONE_TYPE :
                        Toast.makeText(mContext, "请选择入驻类型", Toast.LENGTH_SHORT).show();
                        break;
                    default :
                        break;
                }
                dialog.dismiss();
            }
        });

    }


    private class MyEnterTypeChooseListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.designer_type_rb:
                    mEnterType = Constant.ENTER_TYPE.DESIGNER;
                    break;
                case R.id.supervisor_type_rb:
                    mEnterType = Constant.ENTER_TYPE.SUPERVISOR;
                    break;
                case R.id.scene_manager_type_rb:
                    mEnterType = Constant.ENTER_TYPE.SCENE_MANAGER;
                    break;
                case R.id.worker_type_rb:
                    mEnterType = Constant.ENTER_TYPE.WORKER;
                    break;
                case R.id.material_provider_type_rb:
                    mEnterType = Constant.ENTER_TYPE.MATERIAL_PROVIDER;
                    break;
                default:
                    break;
            }
        }
    }

    private void initBaseViewByUser() {
        if (isDesigner) {
            mEnterLl.setVisibility(View.VISIBLE);
            mCaseManageLl.setVisibility(View.GONE);
            mToDoListLl.setVisibility(View.GONE);
            mBaseInfoLl.setVisibility(View.GONE);
        } else {
            mEnterLl.setVisibility(View.GONE);
            mCaseManageLl.setVisibility(View.VISIBLE);
            mToDoListLl.setVisibility(View.VISIBLE);
            mBaseInfoLl.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public WorkbenchContract.Presenter initPresenter() {
        return new WorkbenchPresenter(this);
    }

    @Override
    @OnClick({R.id.order_manage_ll, R.id.collection_ll, R.id.enter_ll,
            R.id.base_info_ll, R.id.to_do_list_ll, R.id.service_help_ll, R.id.case_manage_ll})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_manage_ll:
                startActivity(OrderManageActivity.class);
                break;
            case R.id.collection_ll:
                startActivity(MyCollectionActivity.class);
                break;
            case R.id.enter_ll:
                isDesigner = false;
                showEnterTypeChooseDialog();
                initBaseViewByUser();
                break;
            case R.id.base_info_ll:
                isDesigner = true;
                initBaseViewByUser();
                break;
            default:
                break;
        }

    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }

}
