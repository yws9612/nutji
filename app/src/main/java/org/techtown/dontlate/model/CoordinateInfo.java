package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoordinateInfo {
    @SerializedName("coordType")
    @Expose
    private String coordType;
    @SerializedName("addressFlag")
    @Expose
    private String addressFlag;
    @SerializedName("matchFlag")
    @Expose
    private String matchFlag;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("city_do")
    @Expose
    private String cityDo;
    @SerializedName("gu_gun")
    @Expose
    private String guGun;
    @SerializedName("eup_myun")
    @Expose
    private String eupMyun;
    @SerializedName("legalDong")
    @Expose
    private String legalDong;
    @SerializedName("legalDongCode")
    @Expose
    private String legalDongCode;
    @SerializedName("adminDong")
    @Expose
    private String adminDong;
    @SerializedName("adminDongCode")
    @Expose
    private String adminDongCode;
    @SerializedName("ri")
    @Expose
    private String ri;
    @SerializedName("bunji")
    @Expose
    private String bunji;
    @SerializedName("newMatchFlag")
    @Expose
    private String newMatchFlag;
    @SerializedName("newLat")
    @Expose
    private String newLat;
    @SerializedName("newLon")
    @Expose
    private String newLon;
    @SerializedName("newRoadName")
    @Expose
    private String newRoadName;
    @SerializedName("newBuildngIndex")
    @Expose
    private String newBuildngIndex;
    @SerializedName("newBuildngName")
    @Expose
    private String newBuildngName;
    @SerializedName("newBuildngCateName")
    @Expose
    private String newBuildngCateName;
    @SerializedName("remainder")
    @Expose
    private String remainder;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("totalCount")
    @Expose
    private String totalCount;
    @SerializedName("coordinate")
    @Expose
    private List<Coordinate> coordinate;

    public String getCoordType() {
        return coordType;
    }

    public void setCoordType(String coordType) {
        this.coordType = coordType;
    }

    public String getssFlag() {
        return addressFlag;
    }

    public void setAddressFlag(String addressFlag) {
        this.addressFlag = addressFlag;
    }

    public String getMatchFlag() {
        return matchFlag;
    }

    public void setMatchFlag(String matchFlag) {
        this.matchFlag = matchFlag;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getCityDo() {
        return cityDo;
    }

    public void setCityDo(String cityDo) {
        this.cityDo = cityDo;
    }

    public String getGuGun() {
        return guGun;
    }

    public void setGuGun(String guGun) {
        this.guGun = guGun;
    }

    public String getEupMyun() {
        return eupMyun;
    }

    public void setEupMyun(String eupMyun) {
        this.eupMyun = eupMyun;
    }

    public String getLegalDong() {
        return legalDong;
    }

    public void setLegalDong(String legalDong) {
        this.legalDong = legalDong;
    }

    public String getLegalDongCode() {
        return legalDongCode;
    }

    public void setLegalDongCode(String legalDongCode) {
        this.legalDongCode = legalDongCode;
    }

    public String getAdminDong() {
        return adminDong;
    }

    public void setAdminDong(String adminDong) {
        this.adminDong = adminDong;
    }

    public String getAdminDongCode() {
        return adminDongCode;
    }

    public void setAdminDongCode(String adminDongCode) {
        this.adminDongCode = adminDongCode;
    }

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public String getBunji() {
        return bunji;
    }

    public void setBunji(String bunji) {
        this.bunji = bunji;
    }

    public String getNewMatchFlag() {
        return newMatchFlag;
    }

    public void setNewMatchFlag(String newMatchFlag) {
        this.newMatchFlag = newMatchFlag;
    }

    public String getNewLat() {
        return newLat;
    }

    public void setNewLat(String newLat) {
        this.newLat = newLat;
    }

    public String getNewLon() {
        return newLon;
    }

    public void setNewLon(String newLon) {
        this.newLon = newLon;
    }

    public String getNewRoadName() {
        return newRoadName;
    }

    public void setNewRoadName(String newRoadName) {
        this.newRoadName = newRoadName;
    }

    public String getNewBuildngIndex() {
        return newBuildngIndex;
    }

    public void setNewBuildngIndex(String newBuildngIndex) {
        this.newBuildngIndex = newBuildngIndex;
    }

    public String getNewBuildngName() {
        return newBuildngName;
    }

    public void setNewBuildngName(String newBuildngName) {
        this.newBuildngName = newBuildngName;
    }

    public String getNewBuildngCateName() {
        return newBuildngCateName;
    }

    public void setNewBuildngCateName(String newBuildngCateName) {
        this.newBuildngCateName = newBuildngCateName;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<Coordinate> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(List<Coordinate> coordinate) {
        this.coordinate = coordinate;
    }
}
