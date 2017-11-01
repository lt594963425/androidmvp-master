package com.antonioleiva.mvpexample.app.mvp.base;

/**
 * $name
 * @author ${LiuTao}
 * @date 2017/10/31/031
 */

public class BasePresenter<V extends BaseView> {
    public V view;

    public V getView() {
        return view;
    }

    /**
     * 绑定View
     */
    public void attachView(V baseView) {
        this.view = baseView;
    }
    /**
     * 解除View
     */

    public void dettachView() {
        this.view = null;
    }

    ;
}
