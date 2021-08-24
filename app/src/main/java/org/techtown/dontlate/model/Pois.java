package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pois {
    @SerializedName("poi")
    @Expose
    private List<Pous> poi;

    public List<Pous> getPoi() {
        return poi;
    }

    public void setPoi(List<Pous> poi) {
        this.poi = poi;
    }
}
