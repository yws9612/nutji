package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UseInfo {
    @SerializedName("platform")
    @Expose
    private Integer platform;
    @SerializedName("meetingPlace")
    @Expose
    private Integer meetingPlace;
    @SerializedName("restroom")
    @Expose
    private Integer restroom;
    @SerializedName("offDoor")
    @Expose
    private Integer offDoor;
    @SerializedName("crossOver")
    @Expose
    private Integer crossOver;
    @SerializedName("publicPlace")
    @Expose
    private Integer publicPlace;
    @SerializedName("handicapCount")
    @Expose
    private Integer handicapCount;
    @SerializedName("parkingCount")
    @Expose
    private Integer parkingCount;
    @SerializedName("bicycleCount")
    @Expose
    private Integer bicycleCount;
    @SerializedName("civilCount")
    @Expose
    private Integer civilCount;

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(Integer meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public Integer getRestroom() {
        return restroom;
    }

    public void setRestroom(Integer restroom) {
        this.restroom = restroom;
    }

    public Integer getOffDoor() {
        return offDoor;
    }

    public void setOffDoor(Integer offDoor) {
        this.offDoor = offDoor;
    }

    public Integer getCrossOver() {
        return crossOver;
    }

    public void setCrossOver(Integer crossOver) {
        this.crossOver = crossOver;
    }

    public Integer getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(Integer publicPlace) {
        this.publicPlace = publicPlace;
    }

    public Integer getHandicapCount() {
        return handicapCount;
    }

    public void setHandicapCount(Integer handicapCount) {
        this.handicapCount = handicapCount;
    }

    public Integer getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(Integer parkingCount) {
        this.parkingCount = parkingCount;
    }

    public Integer getBicycleCount() {
        return bicycleCount;
    }

    public void setBicycleCount(Integer bicycleCount) {
        this.bicycleCount = bicycleCount;
    }

    public Integer getCivilCount() {
        return civilCount;
    }

    public void setCivilCount(Integer civilCount) {
        this.civilCount = civilCount;
    }
}
