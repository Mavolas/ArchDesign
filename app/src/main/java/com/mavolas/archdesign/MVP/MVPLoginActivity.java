package com.mavolas.archdesign.MVP;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mavolas.archdesign.MVC.Model.UserModelImp;
import com.mavolas.archdesign.MVP.bean.User;
import com.mavolas.archdesign.MVP.presenter.UserLoginPresenter;
import com.mavolas.archdesign.MVP.view.IUserLoginView;
import com.mavolas.archdesign.R;

/**
 * Created by 宋棋安
 * on 2018/8/25.
 */
public class MVPLoginActivity extends Activity implements IUserLoginView {


    EditText mUserName,mPassWord;
    TextView mResult;
    ProgressBar mProgressBar;

    private UserLoginPresenter mUserLoginPrestener = new UserLoginPresenter(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_main);

        mUserName =  findViewById(R.id.et_userName);
        mPassWord =  findViewById(R.id.et_passWord);
        mProgressBar= findViewById(R.id.pb_progressBar);
        mResult= findViewById(R.id.tv_result);

    }


    public void DoLogin(View view){

        mUserLoginPrestener.login();

    }

    public void DoClear(View view){

        mUserLoginPrestener.clear();

    }

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mPassWord.getText().toString();
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassWord() {

    }

    @Override
    public void showLoading() {

        mProgressBar.setVisibility( View.VISIBLE );
    }

    @Override
    public void hideLoading() {

        mProgressBar.setVisibility( View.INVISIBLE );

    }

    @Override
    public void toMainActivity(User user) {

        mResult.setText("登陆成功" + user.UserName);

    }

    @Override
    public void showFailedError() {

        mResult.setText("登陆失败");

    }
}
