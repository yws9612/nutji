package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchedPoint {
    @SerializedName("linkId")
    @Expose
    private String linkId;
    @SerializedName("matchedLocation")
    @Expose
    private MatchedLocation matchedLocation;
    @SerializedName("idxName")
    @Expose
    private String idxName;
    @SerializedName("sourceLocation")
    @Expose
    private SourceLocation sourceLocation;
    @SerializedName("sourceIndex")
    @Expose
    private Integer sourceIndex;
    @SerializedName("speed")
    @Expose
    private Integer speed;
    @SerializedName("roadCategory")
    @Expose
    private Integer roadCategory;

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public MatchedLocation getMatchedLocation() {
        return matchedLocation;
    }

    public void setMatchedLocation(MatchedLocation matchedLocation) {
        this.matchedLocation = matchedLocation;
    }

    public String getIdxName() {
        return idxName;
    }

    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }

    public SourceLocation getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(SourceLocation sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getRoadCategory() {
        return roadCategory;
    }

    public void setRoadCategory(Integer roadCategory) {
        this.roadCategory = roadCategory;
    }
}
