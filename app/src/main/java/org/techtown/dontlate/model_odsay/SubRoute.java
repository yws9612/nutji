package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubRoute {
    @SerializedName("globalStartName")
    @Expose
    private String globalStartName;
    @SerializedName("globalEndName")
    @Expose
    private String globalEndName;
    @SerializedName("globalTravelTime")
    @Expose
    private Integer globalTravelTime;
    @SerializedName("globalDistance")
    @Expose
    private Double globalDistance;
    @SerializedName("globalStationCount")
    @Expose
    private Integer globalStationCount;
    @SerializedName("fare")
    @Expose
    private Integer fare;
    @SerializedName("cashFare")
    @Expose
    private Integer cashFare;
    @SerializedName("driveInfoSet")
    @Expose
    private DriveInfoSet driveInfoSet;
    @SerializedName("stationSet")
    @Expose
    private StationSet stationSet;

    public String getGlobalStartName() {
        return globalStartName;
    }

    public void setGlobalStartName(String globalStartName) {
        this.globalStartName = globalStartName;
    }

    public String getGlobalEndName() {
        return globalEndName;
    }

    public void setGlobalEndName(String globalEndName) {
        this.globalEndName = globalEndName;
    }

    public Integer getGlobalTravelTime() {
        return globalTravelTime;
    }

    public void setGlobalTravelTime(Integer globalTravelTime) {
        this.globalTravelTime = globalTravelTime;
    }

    public Double getGlobalDistance() {
        return globalDistance;
    }

    public void setGlobalDistance(Double globalDistance) {
        this.globalDistance = globalDistance;
    }

    public Integer getGlobalStationCount() {
        return globalStationCount;
    }

    public void setGlobalStationCount(Integer globalStationCount) {
        this.globalStationCount = globalStationCount;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }

    public Integer getCashFare() {
        return cashFare;
    }

    public void setCashFare(Integer cashFare) {
        this.cashFare = cashFare;
    }

    public DriveInfoSet getDriveInfoSet() {
        return driveInfoSet;
    }

    public void setDriveInfoSet(DriveInfoSet driveInfoSet) {
        this.driveInfoSet = driveInfoSet;
    }

    public StationSet getStationSet() {
        return stationSet;
    }

    public void setStationSet(StationSet stationSet) {
        this.stationSet = stationSet;
    }
}
