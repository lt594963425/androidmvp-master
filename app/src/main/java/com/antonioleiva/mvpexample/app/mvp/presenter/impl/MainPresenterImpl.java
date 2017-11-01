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
import com.antonioleiva.mvpexample.app.mvp.model.FindItemsInteractor;
import com.antonioleiva.mvpexample.app.mvp.presenter.MainPresenter;
import com.antonioleiva.mvpexample.app.mvp.view.MainView;

import java.util.List;

public class MainPresenterImpl  extends BasePresenter<MainView> implements MainPresenter, FindItemsInteractor.OnFinishedListener {
    //M层
    private FindItemsInteractor findItemsInteractor;
   //绑定M层
    public MainPresenterImpl(FindItemsInteractor findItemsInteractor) {
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {
        if (getView() != null) {
            getView().showProgress();
        }
        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (getView() != null) {
            getView().showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onFinished(List<String> mData) {
        //绑定listView数据成功 mData
        if (getView() != null) {
            getView().setItems(mData);
            getView().hideProgress();
        }
    }



}
