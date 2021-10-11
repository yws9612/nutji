package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geocoding {
    @SerializedName("coordinateInfo")
    @Expose
    private CoordinateInfo coordinateInfo;

    public CoordinateInfo getCoordinateInfo() {
        return coordinateInfo;
    }

    public void setCoordinateInfo(CoordinateInfo coordinateInfo) {
        this.coordinateInfo = coordinateInfo;
    }
}
