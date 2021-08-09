package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RadiusRoute {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("lane")
    @Expose
    private List<LaneTotal> lane = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<LaneTotal> getLane() {
        return lane;
    }

    public void setLane(List<LaneTotal> lane) {
        this.lane = lane;
    }

}
