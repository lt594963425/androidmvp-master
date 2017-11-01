/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.antonioleiva.mvpexample.app.mvp.presenter.impl;

import com.antonioleiva.mvpexample.app.mvp.base.BasePresenter;
import com.antonioleiva.mvpexample.app.mvp.model.LoginInteractor;
import com.antonioleiva.mvpexample.app.mvp.model.LoginInteractorImpl;
import com.antonioleiva.mvpexample.app.mvp.presenter.LoginPresenter;
import com.antonioleiva.mvpexample.app.mvp.view.LoginView;

public class LoginPresenterImpl extends BasePresenter<LoginView> implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginInteractor loginInteractor;//model层

    /**
     * 构造方法 初始化
     * 绑定M层
     */
    public LoginPresenterImpl() {
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (getView() != null) {
            getView().showProgress();
        }
        loginInteractor.login(username, password, this);
    }

    /**
     * 接口的三个方法
     */
    @Override
    public void onUsernameError() {
        if (getView() != null) {
            getView().setUsernameError();
            getView().hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (getView() != null) {
            getView().setPasswordError();
            getView().hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (getView() != null) {
            getView().navigateToHome();
        }
    }

    @Override
    public void onFaild() {
        if (getView() != null){
            getView().setOnFaild();
            getView().hideProgress();
        }
    }


}
