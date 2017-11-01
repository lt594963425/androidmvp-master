package com.antonioleiva.mvpexample.app.mvp.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * $name
 *
 * @author ${LiuTao}
 * @date 2017/11/1/001
 */

public abstract class BaseFragment<P extends BasePresenter,V extends BaseView> extends Fragment {
    private P presenter;
    private V view;

    public P getPresenter() {
        return presenter;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //创建两个层 P，V  ,父类不知道具体创建什么  由子类实现  抽象方法
        if (this.presenter == null) {
            this.presenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }
        if (this.presenter == null) {
            throw new NullPointerException("Presenter不能为空");
        }
        if (this.view == null){
            throw  new NullPointerException("View不能为空");
        }
        this.presenter.attachView(this.view);
    }

    protected abstract V createView();


    public abstract P createPresenter();
}
