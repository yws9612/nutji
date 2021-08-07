package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bus {
    @SerializedName("BusNo")
    @Expose
    private String busNo;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("BlID")
    @Expose
    private String blID;
    @SerializedName("BusCityName")
    @Expose
    private String busCityName;

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBlID() {
        return blID;
    }

    public void setBlID(String blID) {
        this.blID = blID;
    }

    public String getBusCityName() {
        return busCityName;
    }

    public void setBusCityName(String busCityName) {
        this.busCityName = busCityName;
    }
}
