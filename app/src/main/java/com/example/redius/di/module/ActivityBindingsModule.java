package com.example.redius.di.module;

import com.example.redius.MainActivity;
import com.example.redius.MainModule;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBindingsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {MainModule.class})
     MainActivity mainActivity();

}