package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoadCoord {
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("latEntr")
    @Expose
    private String latEntr;
    @SerializedName("lonEntr")
    @Expose
    private String lonEntr;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLatEntr() {
        return latEntr;
    }

    public void setLatEntr(String latEntr) {
        this.latEntr = latEntr;
    }

    public String getLonEntr() {
        return lonEntr;
    }

    public void setLonEntr(String lonEntr) {
        this.lonEntr = lonEntr;
    }
}
