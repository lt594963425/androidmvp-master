package com.antonioleiva.mvpexample.app.mvp.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * model层接口的实现
 */
public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            boolean error = false;
            @Override public void run() {
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error =true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error =true;
                    return;
                }
                if ("15974255013".equals(username)&&"123456".equals(password)){
                    listener.onSuccess();
                    error =true;
                }
                if (!error){
                    listener.onFaild();
                }

            }
        }, 2000);
    }
}
