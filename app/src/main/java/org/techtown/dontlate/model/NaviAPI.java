package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NaviAPI {

    @SerializedName("documents")
    @Expose
    private List<NaviItem> naviItem;

    public List<NaviItem> getNaviItem() {
        return naviItem;
    }

    public void setNaviItem(List<NaviItem> naviItem) {
        this.naviItem = naviItem;
    }

}