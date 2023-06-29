package com.example.redius.di.base;


import com.example.redius.di.module.AppComponent;
import com.example.redius.di.module.DaggerAppComponent;
import com.example.redius.di.module.DatabaseModule;
import com.example.redius.di.module.NetworkModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MyApplication extends DaggerApplication {
    private AppComponent appComponent;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appComponent = DaggerAppComponent.builder()
                .application(this).netModule(new NetworkModule()).dataModule(new DatabaseModule())
                .build();
        appComponent.inject(this);
        return appComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static MyApplication getInstance() {
        return instance;
    }

}


