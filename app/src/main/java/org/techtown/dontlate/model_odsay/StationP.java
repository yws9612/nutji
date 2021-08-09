package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationP {
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("stationID")
    @Expose
    private Integer stationID;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("laneName")
    @Expose
    private String laneName;
    @SerializedName("laneCity")
    @Expose
    private String laneCity;
    @SerializedName("x")
    @Expose
    private Double x;
    @SerializedName("y")
    @Expose
    private Double y;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getStationID() {
        return stationID;
    }

    public void setStationID(Integer stationID) {
        this.stationID = stationID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public String getLaneCity() {
        return laneCity;
    }

    public void setLaneCity(String laneCity) {
        this.laneCity = laneCity;
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
}
