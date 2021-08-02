package org.techtown.dontlate;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class naviAPI {

    @SerializedName("documents")
    @Expose
    private List<naviItems> naviItems = null;

    public List<naviItems> getNaviItems() {
        return naviItems;
    }

    public void setNaviItems(List<naviItems> naviItems) {
        this.naviItems = naviItems;
    }

}