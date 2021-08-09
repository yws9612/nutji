package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gate {
    @SerializedName("gateNo")
    @Expose
    private String gateNo;
    @SerializedName("gateLink")
    @Expose
    private List<String> gateLink = null;
    @SerializedName("BUSSTOP")
    @Expose
    private List<BusStop> busstop = null;

    public String getGateNo() {
        return gateNo;
    }

    public void setGateNo(String gateNo) {
        this.gateNo = gateNo;
    }

    public List<String> getGateLink() {
        return gateLink;
    }

    public void setGateLink(List<String> gateLink) {
        this.gateLink = gateLink;
    }

    public List<BusStop> getBusstop() {
        return busstop;
    }

    public void setBusstop(List<BusStop> busstop) {
        this.busstop = busstop;
    }
}
