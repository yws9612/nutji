package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BusRoute {

    @SerializedName("totalCityList")
    @Expose
    private TotalCityList totalCityList;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("lane")
    @Expose
    private List<Lane> lane = null;

    public TotalCityList getTotalCityList() {
        return totalCityList;
    }

    public void setTotalCityList(TotalCityList totalCityList) {
        this.totalCityList = totalCityList;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Lane> getLane() {
        return lane;
    }

    public void setLane(List<Lane> lane) {
        this.lane = lane;
    }

}
