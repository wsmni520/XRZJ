package com.xrzj.decoration.ztest.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;
import com.xrzj.decoration.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity implements ITestView, View.OnClickListener {

    @BindView(R.id.key)
    TextView mKey;
    @BindView(R.id.token)
    TextView mToken;
    @BindView(R.id.gettoken)
    Button mGettoken;
    private TextView mIp;
    private TextView mCountry;
    private TextView mArea;
    private TextView mRegion;
    private TextView mCity;
    private TextView mCounty;
    private EditText mInput;
    private Button mBtn;
    private TestPresenter mTestPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TestActivity", "onCreate");
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initViews();
        mTestPresenter = new TestPresenter(this);
        mBtn.setOnClickListener(this);
        mTestPresenter.setActivity(this);
    }


    private void initViews() {
        mInput = (EditText) findViewById(R.id.ipAdrress);
        mBtn = (Button) findViewById(R.id.seach);
        mIp = (TextView) findViewById(R.id.ip);
        mCountry = (TextView) findViewById(R.id.country);
        mArea = (TextView) findViewById(R.id.area);
        mRegion = (TextView) findViewById(R.id.region);
        mCity = (TextView) findViewById(R.id.city);
        mCounty = (TextView) findViewById(R.id.county);
    }

    @Override
    public void searchSuccess() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void searchFailed(String errorMessage) {

    }

    @Override
    public void showKey(String bean) {
        Log.d("TestActivity", "showKey");
        SharedPreferencesUtils.putString(this, "key", bean);
        mKey.setText(bean);
    }

    @Override
    public void showToken(String bean) {
        mToken.setText(bean);
    }

    @Override
    public void showData(TestBean bean) {
        mIp.setText(bean.getIp());
        mCountry.setText(bean.getArea());
        mArea.setText(bean.getCity());
        mRegion.setText(bean.getIsp());
        mCity.setText(bean.getCountry());
        mCounty.setText(bean.getRegion());
    }

    @Override
    public void showErro() {
        Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show();
    }

    @Override
    @OnClick(R.id.gettoken)
    public void onClick(View v) {
        Log.d("TestActivity", "onClick");
        switch (v.getId()) {
            case R.id.seach:
                mTestPresenter.getpublicKey();
                break;
            case R.id.gettoken:
                mTestPresenter.gettoken();
                break;
            default:
                break;
        }
    }
}
