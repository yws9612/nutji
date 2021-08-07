package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrdList {
    @SerializedName("up")
    @Expose
    private Up up;

    public Up getUp() {
        return up;
    }

    public void setUp(Up up) {
        this.up = up;
    }
}
