package com.mavolas.archdesign.MVP.biz;

import com.mavolas.archdesign.MVP.bean.User;

/**
 * Created by 宋棋安
 * on 2018/8/25.
 */
public interface IUserBiz {

      void login (User user , OnLoginListener loginListener);
}
