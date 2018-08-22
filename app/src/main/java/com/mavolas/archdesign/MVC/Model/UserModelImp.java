package com.mavolas.archdesign.MVC.Model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by 宋棋安
 * on {2018/8/22}.
 */
public class UserModelImp implements UserInfoModel {

    @Override
    public void doLogin( final User user, final OnLoginListener listener)  {

        final Handler mainHandler = new Handler(Looper.getMainLooper());

       new Thread(new Runnable() {
           @Override
           public void run() {

               try {

                   Thread.sleep(2000);

                   mainHandler.post(new Runnable() {
                       @Override
                       public void run() {

                           listener.onSuccess(user);
                       }
                   });


               }catch (Exception e){

                   mainHandler.post(new Runnable() {
                       @Override
                       public void run() {

                           listener.onFailed("0");
                       }
                   });

               }

           }
       });

    }
}
