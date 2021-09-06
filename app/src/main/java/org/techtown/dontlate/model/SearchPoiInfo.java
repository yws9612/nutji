package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchPoiInfo {
    @SerializedName("totalCount")
    @Expose
    private String totalCount;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("pois")
    @Expose
    private Pois pois;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Pois getPois() {
        return pois;
    }

    public void setPois(Pois pois) {
        this.pois = pois;
    }
}
