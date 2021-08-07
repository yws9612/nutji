package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriveInfo {
    @SerializedName("laneID")
    @Expose
    private String laneID;
    @SerializedName("laneName")
    @Expose
    private String laneName;
    @SerializedName("startName")
    @Expose
    private String startName;
    @SerializedName("stationCount")
    @Expose
    private Integer stationCount;
    @SerializedName("wayCode")
    @Expose
    private Integer wayCode;
    @SerializedName("wayName")
    @Expose
    private String wayName;

    public String getLaneID() {
        return laneID;
    }

    public void setLaneID(String laneID) {
        this.laneID = laneID;
    }

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public Integer getStationCount() {
        return stationCount;
    }

    public void setStationCount(Integer stationCount) {
        this.stationCount = stationCount;
    }

    public Integer getWayCode() {
        return wayCode;
    }

    public void setWayCode(Integer wayCode) {
        this.wayCode = wayCode;
    }

    public String getWayName() {
        return wayName;
    }

    public void setWayName(String wayName) {
        this.wayName = wayName;
    }
}
