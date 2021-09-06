package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoiSearch {
    @SerializedName("searchPoiInfo")
    @Expose
    private SearchPoiInfo searchPoiInfo;

    public SearchPoiInfo getSearchPoiInfo() {
        return searchPoiInfo;
    }

    public void setSearchPoiInfo(SearchPoiInfo searchPoiInfo) {
        this.searchPoiInfo = searchPoiInfo;
    }
}
