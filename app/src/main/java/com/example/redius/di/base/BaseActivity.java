package com.example.redius.di.base;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        bindViews();
        initView();
    }

    public void initView() {
    }


    private void bindViews() {
        ButterKnife.bind(this);
    }


    protected abstract int getLayoutId();
}
