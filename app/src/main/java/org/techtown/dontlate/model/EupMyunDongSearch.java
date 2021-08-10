package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EupMyunDongSearch {
    @SerializedName("findPoiAreaDataByNameInfo")
    @Expose
    private FindPoiAreaDataByNameInfo findPoiAreaDataByNameInfo;

    public FindPoiAreaDataByNameInfo getFindPoiAreaDataByNameInfo() {
        return findPoiAreaDataByNameInfo;
    }

    public void setFindPoiAreaDataByNameInfo(FindPoiAreaDataByNameInfo findPoiAreaDataByNameInfo) {
        this.findPoiAreaDataByNameInfo = findPoiAreaDataByNameInfo;
    }
}
