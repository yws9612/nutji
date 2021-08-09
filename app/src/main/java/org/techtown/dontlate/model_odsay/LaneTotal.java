package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaneTotal {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subwayCode")
    @Expose
    private Integer subwayCode;
    @SerializedName("subwayCityCode")
    @Expose
    private Integer subwayCityCode;
    @SerializedName("busNo")
    @Expose
    private String busNo;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("busID")
    @Expose
    private Integer busID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubwayCode() {
        return subwayCode;
    }

    public void setSubwayCode(Integer subwayCode) {
        this.subwayCode = subwayCode;
    }

    public Integer getSubwayCityCode() {
        return subwayCityCode;
    }

    public void setSubwayCityCode(Integer subwayCityCode) {
        this.subwayCityCode = subwayCityCode;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBusID() {
        return busID;
    }

    public void setBusID(Integer busID) {
        this.busID = busID;
    }
}
