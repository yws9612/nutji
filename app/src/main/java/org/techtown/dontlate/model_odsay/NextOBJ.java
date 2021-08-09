package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NextOBJ {
    @SerializedName("station")
    @Expose
    private List<StationN> station = null;

    public List<StationN> getStation() {
        return station;
    }

    public void setStation(List<StationN> station) {
        this.station = station;
    }
}
