package com.example.redius.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DataResponse {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("facilities")
    @Expose
    private List<FacilityResponse> facilities;
    @SerializedName("exclusions")
    @Expose
    private List<List<Exclusion>> exclusions;

    public List<FacilityResponse> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<FacilityResponse> facilities) {
        this.facilities = facilities;
    }

    public List<List<Exclusion>> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<List<Exclusion>> exclusions) {
        this.exclusions = exclusions;
    }

}