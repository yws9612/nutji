package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {
    @SerializedName("Idx")
    @Expose
    private Integer idx;
    @SerializedName("list")
    @Expose
    private String list;
    @SerializedName("expList")
    @Expose
    private String expList;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getExpList() {
        return expList;
    }

    public void setExpList(String expList) {
        this.expList = expList;
    }
}
