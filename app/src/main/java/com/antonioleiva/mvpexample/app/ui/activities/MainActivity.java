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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.mvp.base.BaseActivity;
import com.antonioleiva.mvpexample.app.mvp.model.FindItemsInteractorImpl;
import com.antonioleiva.mvpexample.app.mvp.presenter.impl.MainPresenterImpl;
import com.antonioleiva.mvpexample.app.mvp.view.MainView;

import java.util.List;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity<MainPresenterImpl,MainView> implements MainView, AdapterView.OnItemClickListener {

    private ListView listView;
    private ProgressBar progressBar;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =  findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar =  findViewById(R.id.progress);
    }

    @Override
    public MainView createView() {
        return this;
    }



    @Override
    public MainPresenterImpl createPresenter() {
        return new MainPresenterImpl(new FindItemsInteractorImpl());
    }

    @Override protected void onResume() {
        super.onResume();
       getPresenter().onResume();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override public void setItems(List<String> mData) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mData));
    }

    @Override public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        getPresenter().onItemClicked(position);
    }
}
