package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CoordRegionInfo {

    @SerializedName("documents")
    @Expose
    private List<CoordRegionInfoItems> coordRegionInfoItems;

    public List<CoordRegionInfoItems> getCoordRegionInfoItems() {
        return coordRegionInfoItems;
    }

    public void setNaviItem(List<CoordRegionInfoItems> coordRegionInfoItems) {
        this.coordRegionInfoItems = coordRegionInfoItems;
    }

}