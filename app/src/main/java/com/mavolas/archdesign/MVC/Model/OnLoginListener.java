package com.mavolas.archdesign.MVC.Model;

/**
 * Created by 宋棋安
 * on {2018/8/22}.
 */
public interface OnLoginListener {

    void onSuccess(User user);

    void onFailed(String code);
}
