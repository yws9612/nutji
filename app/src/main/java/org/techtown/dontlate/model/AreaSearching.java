package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaSearching {
    @SerializedName("searchRegionsInfo")
    @Expose
    private List<SearchRegionsInfo> searchRegionsInfo;

    public List<SearchRegionsInfo> getSearchRegionsInfo() {
        return searchRegionsInfo;
    }

    public void setSearchRegionsInfo(List<SearchRegionsInfo> searchRegionsInfo) {
        this.searchRegionsInfo = searchRegionsInfo;
    }
}
