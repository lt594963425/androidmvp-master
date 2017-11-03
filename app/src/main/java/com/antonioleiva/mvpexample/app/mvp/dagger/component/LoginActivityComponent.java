package com.antonioleiva.mvpexample.app.mvp.dagger.component;

import com.antonioleiva.mvpexample.app.mvp.dagger.module.LoginActivityModel;
import com.antonioleiva.mvpexample.app.ui.activities.LoginActivity;

import dagger.Component;

/**
 * $name
 *
 * @author ${LiuTao}
 * @date 2017/11/3/003
 */
@Component(modules = LoginActivityModel.class)
public interface LoginActivityComponent {
    void in(LoginActivity loginActivity);

}
