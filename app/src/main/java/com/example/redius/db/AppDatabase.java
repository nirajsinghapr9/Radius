package com.example.redius.db;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.redius.model.DataResponse;
import com.example.redius.model.FacilityResponse;
import com.example.redius.model.Option;


@Database(entities = {FacilityResponse.class, Option.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "radius.db";

    public abstract FacilitiesDao facilitiesDao();

    public void deleteAllData() {
        facilitiesDao().deleteAll();

    }
}


