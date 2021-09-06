package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoiAreaCode {
    @SerializedName("areaDepth")
    @Expose
    private String areaDepth;
    @SerializedName("largeCd")
    @Expose
    private String largeCd;
    @SerializedName("middleCd")
    @Expose
    private String middleCd;
    @SerializedName("smallCd")
    @Expose
    private String smallCd;
    @SerializedName("districtName")
    @Expose
    private String districtName;

    public String getAreaDepth() {
        return areaDepth;
    }

    public void setAreaDepth(String areaDepth) {
        this.areaDepth = areaDepth;
    }

    public String getLargeCd() {
        return largeCd;
    }

    public void setLargeCd(String largeCd) {
        this.largeCd = largeCd;
    }

    public String getMiddleCd() {
        return middleCd;
    }

    public void setMiddleCd(String middleCd) {
        this.middleCd = middleCd;
    }

    public String getSmallCd() {
        return smallCd;
    }

    public void setSmallCd(String smallCd) {
        this.smallCd = smallCd;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
