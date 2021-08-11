package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FindPoiAreaDataByNameInfo {
    @SerializedName("totalCnt")
    @Expose
    private String totalCnt;
    @SerializedName("listCnt")
    @Expose
    private String listCnt;
    @SerializedName("contFlag")
    @Expose
    private String contFlag;
    @SerializedName("dongInfo")
    @Expose
    private List<DongInfo> dongInfo = null;

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

    public List<DongInfo> getDongInfo() {
        return dongInfo;
    }

    public void setDongInfo(List<DongInfo> dongInfo) {
        this.dongInfo = dongInfo;
    }
}
