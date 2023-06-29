package com.example.redius.di.module;


import android.app.Application;

import com.example.redius.di.base.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import com.example.redius.di.module.AppModule;
import com.example.redius.di.module.ActivityBindingsModule;


@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBindingsModule.class, NetworkModule.class, DatabaseModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    void inject(MyApplication appController);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);
        @BindsInstance
        Builder netModule(NetworkModule networkModule);
        @BindsInstance
        Builder dataModule(DatabaseModule databaseModule);
        AppComponent build();
    }
}
