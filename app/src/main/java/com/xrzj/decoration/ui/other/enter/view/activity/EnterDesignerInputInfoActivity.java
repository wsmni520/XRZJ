package com.xrzj.decoration.ui.other.enter.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.base.activity.BaseAppCompatActivity;
import com.xrzj.decoration.ui.other.enter.contract.EnterContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EnterDesignerInputInfoActivity extends BaseAppCompatActivity<EnterContract.Presenter> implements EnterContract.View {

    @BindView(R.id.btnBack)
    ImageView mBtnBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.title_right_pre_iv)
    ImageView mTitleRightPreIv;
    @BindView(R.id.title_right_last_iv)
    ImageView mTitleRightLastIv;
    @BindView(R.id.enter_designer_gender_man_rb)
    RadioButton mEnterDesignerGenderManRb;
    @BindView(R.id.enter_designer_gender_woman_rb)
    RadioButton mEnterDesignerGenderWomanRb;
    @BindView(R.id.enter_designer_european_style_rb)
    RadioButton mEnterDesignerEuropeanStyleRb;
    @BindView(R.id.enter_designer_chinese_style_rb)
    RadioButton mEnterDesignerChineseStyleRb;
    @BindView(R.id.enter_designer_american_style_rb)
    RadioButton mEnterDesignerAmericanStyleRb;
    @BindView(R.id.enter_designer_countryside_style_rb)
    RadioButton mEnterDesignerCountrysideStyleRb;
    @BindView(R.id.enter_designer_modern_style_rb)
    RadioButton mEnterDesignerModernStyleRb;
    @BindView(R.id.enter_mix_style_rb)
    RadioButton mEnterMixStyleRb;
    @BindView(R.id.enter_ikea_style_rb)
    RadioButton mEnterIkeaStyleRb;
    @BindView(R.id.enter_mdtsea_style_rb)
    RadioButton mEnterMdtseaStyleRb;

    private List<RadioButton> mChooseStyle = new ArrayList<>();
    private final static int MAX_CHOOSE_STYLE_NUM = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.enter_designer_input_info_activity;

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public EnterContract.Presenter initPresenter() {
        return null;
    }

    @Override
    @OnClick({R.id.btnBack,R.id.enter_designer_gender_man_rb, R.id.enter_designer_gender_woman_rb,
            R.id.enter_designer_european_style_rb, R.id.enter_designer_chinese_style_rb,
            R.id.enter_designer_american_style_rb, R.id.enter_designer_countryside_style_rb,
            R.id.enter_designer_modern_style_rb, R.id.enter_mix_style_rb, R.id.enter_ikea_style_rb,
            R.id.enter_mdtsea_style_rb})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.enter_designer_gender_man_rb:
                setDesignerGenderMan();
                break;
            case R.id.enter_designer_gender_woman_rb:
                setDesignerGenderWoman();
                break;
            case R.id.enter_designer_european_style_rb:
                addDesignStyle(mEnterDesignerEuropeanStyleRb);
                break;
            case R.id.enter_designer_chinese_style_rb:
                addDesignStyle(mEnterDesignerChineseStyleRb);
                break;
            case R.id.enter_designer_american_style_rb:
                addDesignStyle(mEnterDesignerAmericanStyleRb);
                break;
            case R.id.enter_designer_countryside_style_rb:
                addDesignStyle(mEnterDesignerCountrysideStyleRb);
                break;
            case R.id.enter_designer_modern_style_rb:
                addDesignStyle(mEnterDesignerModernStyleRb);
                break;
            case R.id.enter_mix_style_rb:
                addDesignStyle(mEnterMixStyleRb);
                break;
            case R.id.enter_ikea_style_rb:
                addDesignStyle(mEnterIkeaStyleRb);
                break;
            case R.id.enter_mdtsea_style_rb:
                addDesignStyle(mEnterMdtseaStyleRb);
                break;
            default:
                break;
        }
    }

    private void addDesignStyle(RadioButton designStyle) {
        if (mChooseStyle.size() < MAX_CHOOSE_STYLE_NUM && !mChooseStyle.contains(designStyle)) {
            mChooseStyle.add(designStyle);
            Log.d("mChooseStyleNum1", "mChooseStyleNum:" + mChooseStyle.size() + ",designStyle ischeck : " + designStyle.isChecked());
        } else if (mChooseStyle.size() < MAX_CHOOSE_STYLE_NUM && mChooseStyle.contains(designStyle)) {
            mChooseStyle.remove(designStyle);
            designStyle.setChecked(false);
            Log.d("mChooseStyleNum2", "mChooseStyleNum:" + mChooseStyle.size() + ",designStyle ischeck : " + designStyle.isChecked());
        } else if(mChooseStyle.size() >= MAX_CHOOSE_STYLE_NUM && mChooseStyle.contains(designStyle)){
            mChooseStyle.remove(designStyle);
            designStyle.setChecked(false);
            Log.d("mChooseStyleNum3", "mChooseStyleNum:" + mChooseStyle.size() + ",designStyle ischeck : " + designStyle.isChecked());
        } else {
            designStyle.setChecked(false);
            Toast.makeText(this, "最多选择5个", Toast.LENGTH_SHORT).show();
        }

    }

    private void setDesignerGenderWoman() {
        mEnterDesignerGenderWomanRb.setChecked(true);
        mEnterDesignerGenderManRb.setChecked(false);
    }

    private void setDesignerGenderMan() {
        mEnterDesignerGenderManRb.setChecked(true);
        mEnterDesignerGenderWomanRb.setChecked(false);
    }

    @Override
    public void showLoadingProgress(String msg) {

    }

    @Override
    public void dismissLoadingProgress() {

    }

}
