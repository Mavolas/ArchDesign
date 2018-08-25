package com.mavolas.archdesign.MVP.view;

import com.mavolas.archdesign.MVP.bean.User;

/**
 * Created by 宋棋安
 * on 2018/8/25.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassWord();

    void clearUserName();

    void clearPassWord();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
