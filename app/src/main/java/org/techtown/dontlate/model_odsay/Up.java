package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Up {
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
