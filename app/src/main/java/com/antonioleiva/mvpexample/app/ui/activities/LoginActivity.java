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

package com.antonioleiva.mvpexample.app.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.mvp.base.BaseActivity;
import com.antonioleiva.mvpexample.app.mvp.presenter.impl.LoginPresenterImpl;
import com.antonioleiva.mvpexample.app.mvp.view.LoginView;

/**
 * UI层
 * 只处理生命周期的事情
 * 1.多个Activity要重复实现绑定和解绑的动作  抽象activity类
 * @author Administrator
 */
public class LoginActivity extends BaseActivity<LoginPresenterImpl, LoginView> implements LoginView, View.OnClickListener {
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = findViewById(R.id.progress);
        username =  findViewById(R.id.username);
        password =  findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

    }

    @Override
    public LoginView createView() {
        return this;
    }
    /**
     *   持有presenter的引用
     */
    @Override
    public LoginPresenterImpl createPresenter() {

        return new LoginPresenterImpl();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void setOnFaild() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        getPresenter().validateCredentials(username.getText().toString(), password.getText().toString());
    }

}
