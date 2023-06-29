package com.example.redius.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.redius.model.FacilityResponse;
import com.example.redius.model.Option;

import java.util.List;


@Dao
public interface FacilitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FacilityResponse facilityResponse);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOption(Option optionRes);

    @Update
    void update(FacilityResponse... dataResponses);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<FacilityResponse> facilityResponseList);

    @Query("Select * from m_facilities")
    List<FacilityResponse> getAllFacilities();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllOptions(List<Option> options);

    @Query("Select * from m_options")
    List<Option> optionList();

    @Query("Delete from m_facilities")
    void deleteAll();
}
