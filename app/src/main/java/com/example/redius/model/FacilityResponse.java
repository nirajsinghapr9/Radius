package com.example.redius.model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Entity(tableName = "m_facilities")
@Generated("jsonschema2pojo")
public class FacilityResponse {

    @PrimaryKey
    @NonNull
    @SerializedName("facility_id")
    @Expose
    private String facilityId;
    @SerializedName("name")
    @Expose
    private String name;
    @Ignore
    @SerializedName("options")
    @Expose
    private List<Option> options;


    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}