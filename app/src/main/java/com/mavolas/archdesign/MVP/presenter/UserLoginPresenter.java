package com.mavolas.archdesign.MVP.presenter;

import android.os.Handler;

import com.mavolas.archdesign.MVP.bean.User;
import com.mavolas.archdesign.MVP.biz.IUserBiz;
import com.mavolas.archdesign.MVP.biz.OnLoginListener;
import com.mavolas.archdesign.MVP.biz.UserBiz;
import com.mavolas.archdesign.MVP.view.IUserLoginView;

/**
 * Created by 宋棋安
 * on 2018/8/25.
 */
public class UserLoginPresenter {


    private UserBiz mIUserBiz;

    private IUserLoginView mIUserLoginView;

    private Handler mHandler = new Handler() {};

    public UserLoginPresenter(IUserLoginView IUserLoginView) {
        mIUserBiz = new UserBiz();
        mIUserLoginView = IUserLoginView;
    }

    public void login(){

        mIUserLoginView.showLoading();


        User user =new User( mIUserLoginView.getUserName(),mIUserLoginView.getPassWord() );

        mIUserBiz.login( user, new OnLoginListener( ) {
            @Override
            public void onSuccess(final User user) {

                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIUserLoginView.toMainActivity( user );
                        mIUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void onFailed(String code) {

                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIUserLoginView.showFailedError();

                        mIUserLoginView.hideLoading();
                    }
                });

            }
        } );


    }

    public void clear() {
        mIUserLoginView.clearPassWord();
        mIUserLoginView.clearUserName();
    }


}
