package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SunList {
    @SerializedName("up")
    @Expose
    private UpSun up;

    public UpSun getUp() {
        return up;
    }

    public void setUp(UpSun up) {
        this.up = up;
    }
}
