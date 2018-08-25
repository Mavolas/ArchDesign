package com.mavolas.archdesign.MVP.biz;

import android.os.Handler;
import android.os.Looper;

import com.mavolas.archdesign.MVP.bean.User;

/**
 * Created by 宋棋安
 * on 2018/8/25.
 */
public class UserBiz implements IUserBiz {

    @Override
    public void login(final User user, final OnLoginListener loginListener) {

        new Thread(){
            @Override
            public void run() {
                try {
                    //模拟从网络加载数据，需要时间
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if("username".equals(user.UserName) && "password".equals(user.PassWord)){

                    loginListener.onSuccess(user);

                }else{
                    loginListener.onFailed("0");
                }
            }
        }.start();

    }

}
