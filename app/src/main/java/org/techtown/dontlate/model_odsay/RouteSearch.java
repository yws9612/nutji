package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteSearch {
    @SerializedName("searchType")
    @Expose
    private Integer searchType;
    @SerializedName("outTrafficCheck")
    @Expose
    private Integer outTrafficCheck;
    @SerializedName("busCount")
    @Expose
    private Integer busCount;
    @SerializedName("subwayCount")
    @Expose
    private Integer subwayCount;
    @SerializedName("subwayBusCount")
    @Expose
    private Integer subwayBusCount;
    @SerializedName("pointDistance")
    @Expose
    private Integer pointDistance;
    @SerializedName("startRadius")
    @Expose
    private Integer startRadius;
    @SerializedName("endRadius")
    @Expose
    private Integer endRadius;
    @SerializedName("path")
    @Expose
    private List<Path> path = null;

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getOutTrafficCheck() {
        return outTrafficCheck;
    }

    public void setOutTrafficCheck(Integer outTrafficCheck) {
        this.outTrafficCheck = outTrafficCheck;
    }

    public Integer getBusCount() {
        return busCount;
    }

    public void setBusCount(Integer busCount) {
        this.busCount = busCount;
    }

    public Integer getSubwayCount() {
        return subwayCount;
    }

    public void setSubwayCount(Integer subwayCount) {
        this.subwayCount = subwayCount;
    }

    public Integer getSubwayBusCount() {
        return subwayBusCount;
    }

    public void setSubwayBusCount(Integer subwayBusCount) {
        this.subwayBusCount = subwayBusCount;
    }

    public Integer getPointDistance() {
        return pointDistance;
    }

    public void setPointDistance(Integer pointDistance) {
        this.pointDistance = pointDistance;
    }

    public Integer getStartRadius() {
        return startRadius;
    }

    public void setStartRadius(Integer startRadius) {
        this.startRadius = startRadius;
    }

    public Integer getEndRadius() {
        return endRadius;
    }

    public void setEndRadius(Integer endRadius) {
        this.endRadius = endRadius;
    }

    public List<Path> getPath() {
        return path;
    }

    public void setPath(List<Path> path) {
        this.path = path;
    }
}
