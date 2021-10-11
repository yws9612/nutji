package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchRegionsInfo {
    @SerializedName("regionInfo")
    @Expose
    private RegionInfo regionInfo;

    public RegionInfo getRegionInfo() {
        return regionInfo;
    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.regionInfo = regionInfo;
    }
}
