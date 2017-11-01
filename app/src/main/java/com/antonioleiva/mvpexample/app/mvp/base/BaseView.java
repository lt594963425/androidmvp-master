package com.antonioleiva.mvpexample.app.mvp.base;

/**
 * $name
 * 接口层
 * @author ${LiuTao}
 * @date 2017/10/31/031
 */

public  interface  BaseView {
    //显示加载进度条
    void showProgress();

    //隐藏进度条
    void hideProgress();
}
