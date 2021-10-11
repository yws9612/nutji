package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoiInfo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("poiLat")
    @Expose
    private String poiLat;
    @SerializedName("poiLon")
    @Expose
    private String poiLon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoiLat() {
        return poiLat;
    }

    public void setPoiLat(String poiLat) {
        this.poiLat = poiLat;
    }

    public String getPoiLon() {
        return poiLon;
    }

    public void setPoiLon(String poiLon) {
        this.poiLon = poiLon;
    }
}
