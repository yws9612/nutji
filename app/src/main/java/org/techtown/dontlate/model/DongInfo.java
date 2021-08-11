package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DongInfo {
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("resLon")
    @Expose
    private String resLon;
    @SerializedName("resLat")
    @Expose
    private String resLat;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResLon() {
        return resLon;
    }

    public void setResLon(String resLon) {
        this.resLon = resLon;
    }

    public String getResLat() {
        return resLat;
    }

    public void setResLat(String resLat) {
        this.resLat = resLat;
    }
}
