package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchToRoad {
    @SerializedName("resultData")
    @Expose
    private ResultData resultData;

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }
}
