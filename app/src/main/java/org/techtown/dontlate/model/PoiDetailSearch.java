package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoiDetailSearch {
    @SerializedName("poiDetailInfo")
    @Expose
    private PoiDetailInfo poiDetailInfo;

    public PoiDetailInfo getPoiDetailInfo() {
        return poiDetailInfo;
    }

    public void setPoiDetailInfo(PoiDetailInfo poiDetailInfo) {
        this.poiDetailInfo = poiDetailInfo;
    }
}
