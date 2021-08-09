package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubPath {
    @SerializedName("trafficType")
    @Expose
    private Integer trafficType;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("sectionTime")
    @Expose
    private Integer sectionTime;
    @SerializedName("stationCount")
    @Expose
    private Integer stationCount;
    @SerializedName("lane")
    @Expose
    private List<Lane> lane = null;
    @SerializedName("startName")
    @Expose
    private String startName;
    @SerializedName("startX")
    @Expose
    private Double startX;
    @SerializedName("startY")
    @Expose
    private Double startY;
    @SerializedName("endName")
    @Expose
    private String endName;
    @SerializedName("endX")
    @Expose
    private Double endX;
    @SerializedName("endY")
    @Expose
    private Double endY;
    @SerializedName("way")
    @Expose
    private String way;
    @SerializedName("wayCode")
    @Expose
    private Integer wayCode;
    @SerializedName("door")
    @Expose
    private String door;
    @SerializedName("startID")
    @Expose
    private Integer startID;
    @SerializedName("endID")
    @Expose
    private Integer endID;
    @SerializedName("startExitNo")
    @Expose
    private String startExitNo;
    @SerializedName("startExitX")
    @Expose
    private Double startExitX;
    @SerializedName("startExitY")
    @Expose
    private Double startExitY;
    @SerializedName("endExitNo")
    @Expose
    private String endExitNo;
    @SerializedName("endExitX")
    @Expose
    private Double endExitX;
    @SerializedName("endExitY")
    @Expose
    private Double endExitY;
    @SerializedName("passStopList")
    @Expose
    private PassStopList passStopList;

    public Integer getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(Integer trafficType) {
        this.trafficType = trafficType;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(Integer sectionTime) {
        this.sectionTime = sectionTime;
    }

    public Integer getStationCount() {
        return stationCount;
    }

    public void setStationCount(Integer stationCount) {
        this.stationCount = stationCount;
    }

    public List<Lane> getLane() {
        return lane;
    }

    public void setLane(List<Lane> lane) {
        this.lane = lane;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public Double getStartX() {
        return startX;
    }

    public void setStartX(Double startX) {
        this.startX = startX;
    }

    public Double getStartY() {
        return startY;
    }

    public void setStartY(Double startY) {
        this.startY = startY;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    public Double getEndX() {
        return endX;
    }

    public void setEndX(Double endX) {
        this.endX = endX;
    }

    public Double getEndY() {
        return endY;
    }

    public void setEndY(Double endY) {
        this.endY = endY;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Integer getWayCode() {
        return wayCode;
    }

    public void setWayCode(Integer wayCode) {
        this.wayCode = wayCode;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public Integer getStartID() {
        return startID;
    }

    public void setStartID(Integer startID) {
        this.startID = startID;
    }

    public Integer getEndID() {
        return endID;
    }

    public void setEndID(Integer endID) {
        this.endID = endID;
    }

    public String getStartExitNo() {
        return startExitNo;
    }

    public void setStartExitNo(String startExitNo) {
        this.startExitNo = startExitNo;
    }

    public Double getStartExitX() {
        return startExitX;
    }

    public void setStartExitX(Double startExitX) {
        this.startExitX = startExitX;
    }

    public Double getStartExitY() {
        return startExitY;
    }

    public void setStartExitY(Double startExitY) {
        this.startExitY = startExitY;
    }

    public String getEndExitNo() {
        return endExitNo;
    }

    public void setEndExitNo(String endExitNo) {
        this.endExitNo = endExitNo;
    }

    public Double getEndExitX() {
        return endExitX;
    }

    public void setEndExitX(Double endExitX) {
        this.endExitX = endExitX;
    }

    public Double getEndExitY() {
        return endExitY;
    }

    public void setEndExitY(Double endExitY) {
        this.endExitY = endExitY;
    }

    public PassStopList getPassStopList() {
        return passStopList;
    }

    public void setPassStopList(PassStopList passStopList) {
        this.passStopList = passStopList;
    }
}
