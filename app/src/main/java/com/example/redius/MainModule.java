package com.example.redius;


import com.example.redius.di.module.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface MainModule {
    @ActivityScope
    @Binds
    MainContract.Presenter presenter(MainPresenter presenter);

    @ActivityScope
    @Binds
    MainContract.View view(MainActivity mainActivity);
}