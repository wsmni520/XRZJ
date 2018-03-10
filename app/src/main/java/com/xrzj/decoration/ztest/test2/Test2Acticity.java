package com.xrzj.decoration.ztest.test2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xrzj.decoration.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test2Acticity extends AppCompatActivity implements ITest2View,View.OnClickListener{

    @BindView(R.id.msg)
    TextView mMsg;
    @BindView(R.id.seach)
    Button mSeach;
    private TestPresenter2 mTestPresenter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2_acticity);
        ButterKnife.bind(this);

        mTestPresenter2 = new TestPresenter2(this);


    }

    @Override
    public void searchSuccess() {
    }

    @Override
    public void searchFailed(String errorMessage) {

    }

    @Override
    public void showErro() {
        Toast.makeText(this,"Erro",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(String msg) {
        mMsg.setText(msg);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.seach){
            HashMap<String,String> map = new HashMap<>();
            map.put("beginTime","20180310000000");
            map.put("endTime","20180310000000");
            mTestPresenter2.search(map);
        }
    }
}
