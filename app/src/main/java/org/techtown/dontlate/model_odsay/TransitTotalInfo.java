package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransitTotalInfo {
    @SerializedName("takeStationID")
    @Expose
    private Integer takeStationID;
    @SerializedName("takeLaneName")
    @Expose
    private String takeLaneName;
    @SerializedName("takeLaneID")
    @Expose
    private Integer takeLaneID;
    @SerializedName("takeLaneDirection")
    @Expose
    private String takeLaneDirection;
    @SerializedName("exStationID")
    @Expose
    private Integer exStationID;
    @SerializedName("exLaneName")
    @Expose
    private String exLaneName;
    @SerializedName("exLaneID")
    @Expose
    private Integer exLaneID;
    @SerializedName("exLaneDirection")
    @Expose
    private String exLaneDirection;
    @SerializedName("fastTrainInfo")
    @Expose
    private String fastTrainInfo;
    @SerializedName("FastTrain")
    @Expose
    private Integer fastTrain;
    @SerializedName("FastFastDoor")
    @Expose
    private Integer fastFastDoor;
    @SerializedName("FastTrainNum")
    @Expose
    private Integer fastTrainNum;

    public Integer getTakeStationID() {
        return takeStationID;
    }

    public void setTakeStationID(Integer takeStationID) {
        this.takeStationID = takeStationID;
    }

    public String getTakeLaneName() {
        return takeLaneName;
    }

    public void setTakeLaneName(String takeLaneName) {
        this.takeLaneName = takeLaneName;
    }

    public Integer getTakeLaneID() {
        return takeLaneID;
    }

    public void setTakeLaneID(Integer takeLaneID) {
        this.takeLaneID = takeLaneID;
    }

    public String getTakeLaneDirection() {
        return takeLaneDirection;
    }

    public void setTakeLaneDirection(String takeLaneDirection) {
        this.takeLaneDirection = takeLaneDirection;
    }

    public Integer getExStationID() {
        return exStationID;
    }

    public void setExStationID(Integer exStationID) {
        this.exStationID = exStationID;
    }

    public String getExLaneName() {
        return exLaneName;
    }

    public void setExLaneName(String exLaneName) {
        this.exLaneName = exLaneName;
    }

    public Integer getExLaneID() {
        return exLaneID;
    }

    public void setExLaneID(Integer exLaneID) {
        this.exLaneID = exLaneID;
    }

    public String getExLaneDirection() {
        return exLaneDirection;
    }

    public void setExLaneDirection(String exLaneDirection) {
        this.exLaneDirection = exLaneDirection;
    }

    public String getFastTrainInfo() {
        return fastTrainInfo;
    }

    public void setFastTrainInfo(String fastTrainInfo) {
        this.fastTrainInfo = fastTrainInfo;
    }

    public Integer getFastTrain() {
        return fastTrain;
    }

    public void setFastTrain(Integer fastTrain) {
        this.fastTrain = fastTrain;
    }

    public Integer getFastFastDoor() {
        return fastFastDoor;
    }

    public void setFastFastDoor(Integer fastFastDoor) {
        this.fastFastDoor = fastFastDoor;
    }

    public Integer getFastTrainNum() {
        return fastTrainNum;
    }

    public void setFastTrainNum(Integer fastTrainNum) {
        this.fastTrainNum = fastTrainNum;
    }
}
