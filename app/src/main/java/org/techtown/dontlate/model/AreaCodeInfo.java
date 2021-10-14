package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaCodeInfo {
    @SerializedName("totalCnt")
    @Expose
    private String totalCnt;
    @SerializedName("listCnt")
    @Expose
    private String listCnt;
    @SerializedName("contFlag")
    @Expose
    private String contFlag;
    @SerializedName("poiAreaCodes")
    @Expose
    private List<PoiAreaCode> poiAreaCodes = null;

    public String getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(String totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getListCnt() {
        return listCnt;
    }

    public void setListCnt(String listCnt) {
        this.listCnt = listCnt;
    }

    public String getContFlag() {
        return contFlag;
    }

    public void setContFlag(String contFlag) {
        this.contFlag = contFlag;
    }

    public List<PoiAreaCode> getPoiAreaCodes() {
        return poiAreaCodes;
    }

    public void setPoiAreaCodes(List<PoiAreaCode> poiAreaCodes) {
        this.poiAreaCodes = poiAreaCodes;
    }
}
