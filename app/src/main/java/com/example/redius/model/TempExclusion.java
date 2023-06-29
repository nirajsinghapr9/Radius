package com.example.redius.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TempExclusion {

    @SerializedName("options_id")
    @Expose
    private String optionsId;

    public String getOptionsId() {
        return optionsId;
    }

    public void setOptionsId(String optionsId) {
        this.optionsId = optionsId;
    }

}
