package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("trafficDistance")
    @Expose
    private Integer trafficDistance;
    @SerializedName("totalWalk")
    @Expose
    private Integer totalWalk;
    @SerializedName("totalTime")
    @Expose
    private Integer totalTime;
    @SerializedName("payment")
    @Expose
    private Integer payment;
    @SerializedName("busTransitCount")
    @Expose
    private Integer busTransitCount;
    @SerializedName("subwayTransitCount")
    @Expose
    private Integer subwayTransitCount;
    @SerializedName("mapObj")
    @Expose
    private String mapObj;
    @SerializedName("firstStartStation")
    @Expose
    private String firstStartStation;
    @SerializedName("lastEndStation")
    @Expose
    private String lastEndStation;
    @SerializedName("totalStationCount")
    @Expose
    private Integer totalStationCount;
    @SerializedName("busStationCount")
    @Expose
    private Integer busStationCount;
    @SerializedName("subwayStationCount")
    @Expose
    private Integer subwayStationCount;
    @SerializedName("totalDistance")
    @Expose
    private Integer totalDistance;
    @SerializedName("totalWalkTime")
    @Expose
    private Integer totalWalkTime;
    @SerializedName("busIntervalTemp")
    @Expose
    private Integer busIntervalTemp;

    public Integer getTrafficDistance() {
        return trafficDistance;
    }

    public void setTrafficDistance(Integer trafficDistance) {
        this.trafficDistance = trafficDistance;
    }

    public Integer getTotalWalk() {
        return totalWalk;
    }

    public void setTotalWalk(Integer totalWalk) {
        this.totalWalk = totalWalk;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getBusTransitCount() {
        return busTransitCount;
    }

    public void setBusTransitCount(Integer busTransitCount) {
        this.busTransitCount = busTransitCount;
    }

    public Integer getSubwayTransitCount() {
        return subwayTransitCount;
    }

    public void setSubwayTransitCount(Integer subwayTransitCount) {
        this.subwayTransitCount = subwayTransitCount;
    }

    public String getMapObj() {
        return mapObj;
    }

    public void setMapObj(String mapObj) {
        this.mapObj = mapObj;
    }

    public String getFirstStartStation() {
        return firstStartStation;
    }

    public void setFirstStartStation(String firstStartStation) {
        this.firstStartStation = firstStartStation;
    }

    public String getLastEndStation() {
        return lastEndStation;
    }

    public void setLastEndStation(String lastEndStation) {
        this.lastEndStation = lastEndStation;
    }

    public Integer getTotalStationCount() {
        return totalStationCount;
    }

    public void setTotalStationCount(Integer totalStationCount) {
        this.totalStationCount = totalStationCount;
    }

    public Integer getBusStationCount() {
        return busStationCount;
    }

    public void setBusStationCount(Integer busStationCount) {
        this.busStationCount = busStationCount;
    }

    public Integer getSubwayStationCount() {
        return subwayStationCount;
    }

    public void setSubwayStationCount(Integer subwayStationCount) {
        this.subwayStationCount = subwayStationCount;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Integer getTotalWalkTime() {
        return totalWalkTime;
    }

    public void setTotalWalkTime(Integer totalWalkTime) {
        this.totalWalkTime = totalWalkTime;
    }

    public Integer getBusIntervalTemp() {
        return busIntervalTemp;
    }

    public void setBusIntervalTemp(Integer busIntervalTemp) {
        this.busIntervalTemp = busIntervalTemp;
    }
}
