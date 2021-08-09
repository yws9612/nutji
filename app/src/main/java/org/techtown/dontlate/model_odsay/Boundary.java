package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Boundary {
    @SerializedName("top")
    @Expose
    private Double top;
    @SerializedName("left")
    @Expose
    private Double left;
    @SerializedName("bottom")
    @Expose
    private Double bottom;
    @SerializedName("right")
    @Expose
    private Double right;

    public Double getTop() {
        return top;
    }

    public void setTop(Double top) {
        this.top = top;
    }

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }

    public Double getBottom() {
        return bottom;
    }

    public void setBottom(Double bottom) {
        this.bottom = bottom;
    }

    public Double getRight() {
        return right;
    }

    public void setRight(Double right) {
        this.right = right;
    }
}
