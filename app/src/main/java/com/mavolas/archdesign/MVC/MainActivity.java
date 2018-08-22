package com.mavolas.archdesign.MVC;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mavolas.archdesign.MVC.Model.OnLoginListener;
import com.mavolas.archdesign.MVC.Model.User;
import com.mavolas.archdesign.MVC.Model.UserInfoModel;
import com.mavolas.archdesign.MVC.Model.UserModelImp;
import com.mavolas.archdesign.R;

public class MainActivity extends AppCompatActivity implements OnLoginListener{


    EditText mUserName,mPassWord;
    TextView mResult;
    ProgressBar mProgressBar;

    private UserModelImp userModelImp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userModelImp = new UserModelImp();

        mUserName =  findViewById(R.id.et_userName);
        mPassWord =  findViewById(R.id.et_passWord);
        mProgressBar= findViewById(R.id.pb_progressBar);
        mResult= findViewById(R.id.tv_result);

    }


    public void DoLogin(View view){

        mProgressBar.setVisibility(View.VISIBLE);

        User data =new User(mUserName.getText().toString() , mPassWord.getText().toString());

        userModelImp.doLogin(data,MainActivity.this);

    }

    @Override
    public void onSuccess(User user) {

        mProgressBar.setVisibility(View.INVISIBLE);
        mResult.setText("登陆成功" + user.UserName);
    }

    @Override
    public void onFailed(String code) {

        mProgressBar.setVisibility(View.INVISIBLE);
        mResult.setText("登陆失败");

    }
}
