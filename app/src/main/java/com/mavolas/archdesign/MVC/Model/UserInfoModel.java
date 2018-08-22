package com.mavolas.archdesign.MVC.Model;

import android.content.Context;

/**
 * Created by 宋棋安
 * on {2018/8/22}.
 */
public interface UserInfoModel {

    void  doLogin(User user , OnLoginListener listener );
}
