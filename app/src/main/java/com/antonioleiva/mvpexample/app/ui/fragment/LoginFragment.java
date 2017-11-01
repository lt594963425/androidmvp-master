package com.antonioleiva.mvpexample.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.mvp.base.BaseFragment;
import com.antonioleiva.mvpexample.app.mvp.presenter.impl.LoginPresenterImpl;
import com.antonioleiva.mvpexample.app.mvp.view.LoginView;

/**
 * $name
 *
 * @author ${LiuTao}
 * @date 2017/11/1/001
 */

public class LoginFragment extends BaseFragment<LoginPresenterImpl, LoginView> implements LoginView, View.OnClickListener {
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_login, null);
        progressBar = v.findViewById(R.id.progress);
        username = v.findViewById(R.id.username);
        password = v.findViewById(R.id.password);
        v. findViewById(R.id.button).setOnClickListener(this);
        return v;

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
        Toast.makeText(getActivity(),"登录成功",Toast.LENGTH_LONG).show();

    }

    @Override
    public void setOnFaild() {
        Toast.makeText(getActivity(),"登录失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        getPresenter().validateCredentials(username.getText().toString(), password.getText().toString());
    }


    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    public LoginPresenterImpl createPresenter() {

        return new LoginPresenterImpl();
    }
}
