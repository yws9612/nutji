package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionDivide {
    @SerializedName("areaCodeInfo")
    @Expose
    private AreaCodeInfo areaCodeInfo;

    public AreaCodeInfo getAreaCodeInfo() {
        return areaCodeInfo;
    }

    public void setAreaCodeInfo(AreaCodeInfo areaCodeInfo) {
        this.areaCodeInfo = areaCodeInfo;
    }
}
