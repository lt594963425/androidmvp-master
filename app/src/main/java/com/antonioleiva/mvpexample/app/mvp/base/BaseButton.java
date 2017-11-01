package com.antonioleiva.mvpexample.app.mvp.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * $name
 *
 * @author ${LiuTao}
 * @date 2017/11/1/001
 */

public abstract class BaseButton<P extends BasePresenter<V>,V extends BaseView> extends Button {

    private P presenter;
    private V view;

    public P getPresenter() {
        return presenter;
    }
    public BaseButton(Context context) {
        super(context);
    }

    public BaseButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
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

    protected abstract P createPresenter();

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.dettachView();
    }
}
