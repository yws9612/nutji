package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpSun {
    @SerializedName("time")
    @Expose
    private List<Time> time = null;

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }
}
