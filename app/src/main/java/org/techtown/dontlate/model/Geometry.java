package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geometry {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("coordinates")
    @Expose
    private List<List<List<String>>> coordinates;
    @SerializedName("traffic")
    @Expose
    private List<String> traffic = null;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<List<String>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<String>>> coordinates) {
        this.coordinates = coordinates;
    }

    public List<String> getTraffic() {
        return traffic;
    }

    public void setTraffic(List<String> traffic) {
        this.traffic = traffic;
    }
}
