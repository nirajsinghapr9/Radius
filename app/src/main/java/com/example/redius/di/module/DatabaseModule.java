package com.example.redius.di.module;

import android.content.Context;

import androidx.room.Room;

import com.example.redius.db.AppDatabase;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    AppDatabase providesAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

}