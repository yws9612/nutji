package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusLocation {

    @SerializedName("busId")
    @Expose
    private String busId;
    @SerializedName("busPlateNo")
    @Expose
    private String busPlateNo;
    @SerializedName("routeId")
    @Expose
    private String routeId;
    @SerializedName("seoulProvdTm")
    @Expose
    private String seoulProvdTm;
    @SerializedName("fromStationId")
    @Expose
    private String fromStationId;
    @SerializedName("fromStationSeq")
    @Expose
    private String fromStationSeq;
    @SerializedName("endBusYn")
    @Expose
    private String endBusYn;
    @SerializedName("lowBusYn")
    @Expose
    private String lowBusYn;
    @SerializedName("toStationSeq")
    @Expose
    private String toStationSeq;
    @SerializedName("busPosition")
    @Expose
    private String busPosition;
    @SerializedName("toStationId")
    @Expose
    private String toStationId;

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusPlateNo() {
        return busPlateNo;
    }

    public void setBusPlateNo(String busPlateNo) {
        this.busPlateNo = busPlateNo;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getSeoulProvdTm() {
        return seoulProvdTm;
    }

    public void setSeoulProvdTm(String seoulProvdTm) {
        this.seoulProvdTm = seoulProvdTm;
    }

    public String getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(String fromStationId) {
        this.fromStationId = fromStationId;
    }

    public String getFromStationSeq() {
        return fromStationSeq;
    }

    public void setFromStationSeq(String fromStationSeq) {
        this.fromStationSeq = fromStationSeq;
    }

    public String getEndBusYn() {
        return endBusYn;
    }

    public void setEndBusYn(String endBusYn) {
        this.endBusYn = endBusYn;
    }

    public String getLowBusYn() {
        return lowBusYn;
    }

    public void setLowBusYn(String lowBusYn) {
        this.lowBusYn = lowBusYn;
    }

    public String getToStationSeq() {
        return toStationSeq;
    }

    public void setToStationSeq(String toStationSeq) {
        this.toStationSeq = toStationSeq;
    }

    public String getBusPosition() {
        return busPosition;
    }

    public void setBusPosition(String busPosition) {
        this.busPosition = busPosition;
    }

    public String getToStationId() {
        return toStationId;
    }

    public void setToStationId(String toStationId) {
        this.toStationId = toStationId;
    }
}
