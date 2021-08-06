package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EvCharger {
    @SerializedName("bid")
    @Expose
    private String bid;
    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("evPowerType")
    @Expose
    private String evPowerType;
    @SerializedName("chargingDateTime")
    @Expose
    private String chargingDateTime;
    @SerializedName("updateDateTime")
    @Expose
    private String updateDateTime;
    @SerializedName("calculatedDateTime")
    @Expose
    private String calculatedDateTime;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEvPowerType() {
        return evPowerType;
    }

    public void setEvPowerType(String evPowerType) {
        this.evPowerType = evPowerType;
    }

    public String getChargingDateTime() {
        return chargingDateTime;
    }

    public void setChargingDateTime(String chargingDateTime) {
        this.chargingDateTime = chargingDateTime;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getCalculatedDateTime() {
        return calculatedDateTime;
    }

    public void setCalculatedDateTime(String calculatedDateTime) {
        this.calculatedDateTime = calculatedDateTime;
    }
}
