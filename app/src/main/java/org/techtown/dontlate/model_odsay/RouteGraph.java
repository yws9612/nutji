package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteGraph {
    @SerializedName("lane")
    @Expose
    private List<LaneGraph> lane = null;
    @SerializedName("boundary")
    @Expose
    private Boundary boundary;

    public List<LaneGraph> getLane() {
        return lane;
    }

    public void setLane(List<LaneGraph> lane) {
        this.lane = lane;
    }

    public Boundary getBoundary() {
        return boundary;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
