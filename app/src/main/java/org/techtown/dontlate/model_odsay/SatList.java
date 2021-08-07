package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SatList {
    @SerializedName("up")
    @Expose
    private UpSat up;

    public UpSat getUp() {
        return up;
    }

    public void setUp(UpSat up) {
        this.up = up;
    }
}
