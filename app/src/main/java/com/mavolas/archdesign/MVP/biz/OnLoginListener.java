package com.mavolas.archdesign.MVP.biz;


import com.mavolas.archdesign.MVP.bean.User;

/**
 * Created by 宋棋安
 * on 2018/8/25.
 */
public interface OnLoginListener {

    void onSuccess(User user);

    void onFailed(String code);

}
