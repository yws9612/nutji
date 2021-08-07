package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrevOBJ {
    @SerializedName("station")
    @Expose
    private List<StationP> station = null;

    public List<StationP> getStation() {
        return station;
    }

    public void setStation(List<StationP> station) {
        this.station = station;
    }
}
