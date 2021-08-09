package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicTransitStop {
    @SerializedName("totalCityList")
    @Expose
    private TotalCityList totalCityList;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("station")
    @Expose
    private List<Station> station = null;

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

    public List<Station> getStation() {
        return station;
    }

    public void setStation(List<Station> station) {
        this.station = station;
    }
}
