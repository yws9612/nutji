package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {
    @SerializedName("linkId")
    @Expose
    private String linkId;
    @SerializedName("tollLink")
    @Expose
    private String tollLink;
    @SerializedName("idxName")
    @Expose
    private String idxName;
    @SerializedName("totalDistance")
    @Expose
    private String totalDistance;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("roadName")
    @Expose
    private String roadName;
    @SerializedName("lane")
    @Expose
    private String lane;
    @SerializedName("laneType")
    @Expose
    private String laneType;
    @SerializedName("roadCategory")
    @Expose
    private String roadCategory;
    @SerializedName("linkFacil")
    @Expose
    private String linkFacil;

    @SerializedName("totalPointCount")
    @Expose
    private String totalPointCount;
    @SerializedName("matchedLinkCount")
    @Expose
    private String matchedLinkCount;

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getTollLink() {
        return tollLink;
    }

    public void setTollLink(String tollLink) {
        this.tollLink = tollLink;
    }

    public String getIdxName() {
        return idxName;
    }

    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }

    public String getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getLaneType() {
        return laneType;
    }

    public void setLaneType(String laneType) {
        this.laneType = laneType;
    }

    public String getRoadCategory() {
        return roadCategory;
    }

    public void setRoadCategory(String roadCategory) {
        this.roadCategory = roadCategory;
    }

    public String getLinkFacil() {
        return linkFacil;
    }

    public void setLinkFacil(String linkFacil) {
        this.linkFacil = linkFacil;
    }

    public String getTotalPointCount() {
        return totalPointCount;
    }

    public void setTotalPointCount(String totalPointCount) {
        this.totalPointCount = totalPointCount;
    }

    public String getMatchedLinkCount() {
        return matchedLinkCount;
    }

    public void setMatchedLinkCount(String matchedLinkCount) {
        this.matchedLinkCount = matchedLinkCount;
    }
}
