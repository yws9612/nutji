package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubTimetable {
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("laneName")
    @Expose
    private String laneName;
    @SerializedName("laneCity")
    @Expose
    private String laneCity;
    @SerializedName("OrdList")
    @Expose
    private OrdList ordList;
    @SerializedName("SatList")
    @Expose
    private SatList satList;
    @SerializedName("SunList")
    @Expose
    private SunList sunList;
    @SerializedName("upWay")
    @Expose
    private String upWay;
    @SerializedName("downWay")
    @Expose
    private String downWay;
    @SerializedName("stationID")
    @Expose
    private Integer stationID;
    @SerializedName("stationName")
    @Expose
    private String stationName;

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

    public OrdList getOrdList() {
        return ordList;
    }

    public void setOrdList(OrdList ordList) {
        this.ordList = ordList;
    }

    public SatList getSatList() {
        return satList;
    }

    public void setSatList(SatList satList) {
        this.satList = satList;
    }

    public SunList getSunList() {
        return sunList;
    }

    public void setSunList(SunList sunList) {
        this.sunList = sunList;
    }

    public String getUpWay() {
        return upWay;
    }

    public void setUpWay(String upWay) {
        this.upWay = upWay;
    }

    public String getDownWay() {
        return downWay;
    }

    public void setDownWay(String downWay) {
        this.downWay = downWay;
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
}
