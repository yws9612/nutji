package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewAddress {
    @SerializedName("centerLat")
    @Expose
    private String centerLat;
    @SerializedName("centerLon")
    @Expose
    private String centerLon;
    @SerializedName("frontLat")
    @Expose
    private String frontLat;
    @SerializedName("frontLon")
    @Expose
    private String frontLon;
    @SerializedName("roadName")
    @Expose
    private String roadName;
    @SerializedName("bldNo1")
    @Expose
    private String bldNo1;
    @SerializedName("bldNo2")
    @Expose
    private String bldNo2;
    @SerializedName("roadId")
    @Expose
    private String roadId;
    @SerializedName("fullAddressRoad")
    @Expose
    private String fullAddressRoad;

    public String getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(String centerLat) {
        this.centerLat = centerLat;
    }

    public String getCenterLon() {
        return centerLon;
    }

    public void setCenterLon(String centerLon) {
        this.centerLon = centerLon;
    }

    public String getFrontLat() {
        return frontLat;
    }

    public void setFrontLat(String frontLat) {
        this.frontLat = frontLat;
    }

    public String getFrontLon() {
        return frontLon;
    }

    public void setFrontLon(String frontLon) {
        this.frontLon = frontLon;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getBldNo1() {
        return bldNo1;
    }

    public void setBldNo1(String bldNo1) {
        this.bldNo1 = bldNo1;
    }

    public String getBldNo2() {
        return bldNo2;
    }

    public void setBldNo2(String bldNo2) {
        this.bldNo2 = bldNo2;
    }

    public String getRoadId() {
        return roadId;
    }

    public void setRoadId(String roadId) {
        this.roadId = roadId;
    }

    public String getFullAddressRoad() {
        return fullAddressRoad;
    }

    public void setFullAddressRoad(String fullAddressRoad) {
        this.fullAddressRoad = fullAddressRoad;
    }
}
