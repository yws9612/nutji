package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusRouteInfo {
    @SerializedName("busNo")
    @Expose
    private String busNo;
    @SerializedName("busID")
    @Expose
    private Integer busID;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("busCityName")
    @Expose
    private String busCityName;
    @SerializedName("busCityCode")
    @Expose
    private Integer busCityCode;
    @SerializedName("busStartPoint")
    @Expose
    private String busStartPoint;
    @SerializedName("busEndPoint")
    @Expose
    private String busEndPoint;
    @SerializedName("busFirstTime")
    @Expose
    private String busFirstTime;
    @SerializedName("busLastTime")
    @Expose
    private String busLastTime;
    @SerializedName("busInterval")
    @Expose
    private String busInterval;
    @SerializedName("busTotalDistance")
    @Expose
    private Integer busTotalDistance;
    @SerializedName("bus_Ep_FirstTime")
    @Expose
    private String busEpFirstTime;
    @SerializedName("bus_Ep_LastTime")
    @Expose
    private String busEpLastTime;
    @SerializedName("bus_Interval_Week")
    @Expose
    private String busIntervalWeek;
    @SerializedName("bus_Interval_Sat")
    @Expose
    private String busIntervalSat;
    @SerializedName("bus_Interval_Sun")
    @Expose
    private String busIntervalSun;
    @SerializedName("bus_Interval_Rushhour")
    @Expose
    private String busIntervalRushhour;
    @SerializedName("busLocalBlID")
    @Expose
    private String busLocalBlID;
    @SerializedName("station")
    @Expose
    private List<Station> station = null;

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public Integer getBusID() {
        return busID;
    }

    public void setBusID(Integer busID) {
        this.busID = busID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBusCityName() {
        return busCityName;
    }

    public void setBusCityName(String busCityName) {
        this.busCityName = busCityName;
    }

    public Integer getBusCityCode() {
        return busCityCode;
    }

    public void setBusCityCode(Integer busCityCode) {
        this.busCityCode = busCityCode;
    }

    public String getBusStartPoint() {
        return busStartPoint;
    }

    public void setBusStartPoint(String busStartPoint) {
        this.busStartPoint = busStartPoint;
    }

    public String getBusEndPoint() {
        return busEndPoint;
    }

    public void setBusEndPoint(String busEndPoint) {
        this.busEndPoint = busEndPoint;
    }

    public String getBusFirstTime() {
        return busFirstTime;
    }

    public void setBusFirstTime(String busFirstTime) {
        this.busFirstTime = busFirstTime;
    }

    public String getBusLastTime() {
        return busLastTime;
    }

    public void setBusLastTime(String busLastTime) {
        this.busLastTime = busLastTime;
    }

    public String getBusInterval() {
        return busInterval;
    }

    public void setBusInterval(String busInterval) {
        this.busInterval = busInterval;
    }

    public Integer getBusTotalDistance() {
        return busTotalDistance;
    }

    public void setBusTotalDistance(Integer busTotalDistance) {
        this.busTotalDistance = busTotalDistance;
    }

    public String getBusEpFirstTime() {
        return busEpFirstTime;
    }

    public void setBusEpFirstTime(String busEpFirstTime) {
        this.busEpFirstTime = busEpFirstTime;
    }

    public String getBusEpLastTime() {
        return busEpLastTime;
    }

    public void setBusEpLastTime(String busEpLastTime) {
        this.busEpLastTime = busEpLastTime;
    }

    public String getBusIntervalWeek() {
        return busIntervalWeek;
    }

    public void setBusIntervalWeek(String busIntervalWeek) {
        this.busIntervalWeek = busIntervalWeek;
    }

    public String getBusIntervalSat() {
        return busIntervalSat;
    }

    public void setBusIntervalSat(String busIntervalSat) {
        this.busIntervalSat = busIntervalSat;
    }

    public String getBusIntervalSun() {
        return busIntervalSun;
    }

    public void setBusIntervalSun(String busIntervalSun) {
        this.busIntervalSun = busIntervalSun;
    }

    public String getBusIntervalRushhour() {
        return busIntervalRushhour;
    }

    public void setBusIntervalRushhour(String busIntervalRushhour) {
        this.busIntervalRushhour = busIntervalRushhour;
    }

    public String getBusLocalBlID() {
        return busLocalBlID;
    }

    public void setBusLocalBlID(String busLocalBlID) {
        this.busLocalBlID = busLocalBlID;
    }

    public List<Station> getStation() {
        return station;
    }

    public void setStation(List<Station> station) {
        this.station = station;
    }
}
