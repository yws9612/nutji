package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {
    @SerializedName("idx")
    @Expose
    private Integer idx;
    @SerializedName("stationID")
    @Expose
    private Integer stationID;
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("stationDistance")
    @Expose
    private Integer stationDistance;
    @SerializedName("stationDirection")
    @Expose
    private Integer stationDirection;
    @SerializedName("arsID")
    @Expose
    private String arsID;
    @SerializedName("x")
    @Expose
    private Double x;
    @SerializedName("y")
    @Expose
    private Double y;
    @SerializedName("localStationID")
    @Expose
    private String localStationID;
    @SerializedName("stationCityCode")
    @Expose
    private String stationCityCode;
    @SerializedName("nonstopStation")
    @Expose
    private Integer nonstopStation;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getStationID() {
        return stationID;
    }

    public void setStationID(Integer stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getStationDistance() {
        return stationDistance;
    }

    public void setStationDistance(Integer stationDistance) {
        this.stationDistance = stationDistance;
    }

    public Integer getStationDirection() {
        return stationDirection;
    }

    public void setStationDirection(Integer stationDirection) {
        this.stationDirection = stationDirection;
    }

    public String getArsID() {
        return arsID;
    }

    public void setArsID(String arsID) {
        this.arsID = arsID;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getLocalStationID() {
        return localStationID;
    }

    public void setLocalStationID(String localStationID) {
        this.localStationID = localStationID;
    }

    public String getStationCityCode() {
        return stationCityCode;
    }

    public void setStationCityCode(String stationCityCode) {
        this.stationCityCode = stationCityCode;
    }

    public Integer getNonstopStation() {
        return nonstopStation;
    }

    public void setNonstopStation(Integer nonstopStation) {
        this.nonstopStation = nonstopStation;
    }
}
