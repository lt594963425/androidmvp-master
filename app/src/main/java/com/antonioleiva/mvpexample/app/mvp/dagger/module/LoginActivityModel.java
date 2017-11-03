package com.antonioleiva.mvpexample.app.mvp.dagger.module;

import com.antonioleiva.mvpexample.app.mvp.presenter.impl.LoginPresenterImpl;
import com.antonioleiva.mvpexample.app.ui.activities.LoginActivity;

import dagger.Module;
import dagger.Provides;

/**
 * $name
 *
 * @author ${LiuTao}
 * @date 2017/11/3/003
 */
@Module
public class LoginActivityModel {
    LoginActivity mLoginActivity;
    public LoginActivityModel(LoginActivity loginActivity) {
        this.mLoginActivity  =loginActivity;
    }
    @Provides
    public LoginPresenterImpl providesLoginPresenter(){
        return new  LoginPresenterImpl();
    }
}
