package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubTransfer {
    @SerializedName("transitTotalInfo")
    @Expose
    private List<TransitTotalInfo> transitTotalInfo = null;
    @SerializedName("count")
    @Expose
    private Integer count;

    public List<TransitTotalInfo> getTransitTotalInfo() {
        return transitTotalInfo;
    }

    public void setTransitTotalInfo(List<TransitTotalInfo> transitTotalInfo) {
        this.transitTotalInfo = transitTotalInfo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
