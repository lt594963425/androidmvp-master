package com.antonioleiva.mvpexample.app.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * $name
 * 高度抽象层
 *
 * @author ${LiuTao}
 * @date 2017/11/1/001
 */

public abstract class BaseActivity<P extends BasePresenter<V>, V extends BaseView> extends Activity {
    private P presenter;
    private V view;

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


    public abstract V createView();

    public abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.dettachView();
    }
}
