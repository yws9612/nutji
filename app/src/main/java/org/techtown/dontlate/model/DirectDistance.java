package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DirectDistance {
    @SerializedName("distanceInfo")
    @Expose
    private DistanceInfo distanceInfo;

    public DistanceInfo getDistanceInfo() {
        return distanceInfo;
    }

    public void setDistanceInfo(DistanceInfo distanceInfo) {
        this.distanceInfo = distanceInfo;
    }
}
