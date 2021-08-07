package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubStation {
    @SerializedName("startID")
    @Expose
    private Integer startID;
    @SerializedName("startName")
    @Expose
    private String startName;
    @SerializedName("endSID")
    @Expose
    private Integer endSID;
    @SerializedName("endName")
    @Expose
    private String endName;
    @SerializedName("travelTime")
    @Expose
    private Integer travelTime;

    public Integer getStartID() {
        return startID;
    }

    public void setStartID(Integer startID) {
        this.startID = startID;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public Integer getEndSID() {
        return endSID;
    }

    public void setEndSID(Integer endSID) {
        this.endSID = endSID;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    public Integer getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }
}
