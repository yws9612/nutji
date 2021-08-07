package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusStopInfo {
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("stationID")
    @Expose
    private Integer stationID;
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
    @SerializedName("arsID")
    @Expose
    private String arsID;
    @SerializedName("do")
    @Expose
    private String _do;
    @SerializedName("gu")
    @Expose
    private String gu;
    @SerializedName("dong")
    @Expose
    private String dong;
    @SerializedName("lane")
    @Expose
    private List<Lane> lane = null;

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

    public String getArsID() {
        return arsID;
    }

    public void setArsID(String arsID) {
        this.arsID = arsID;
    }

    public String getDo() {
        return _do;
    }

    public void setDo(String _do) {
        this._do = _do;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public List<Lane> getLane() {
        return lane;
    }

    public void setLane(List<Lane> lane) {
        this.lane = lane;
    }
}
