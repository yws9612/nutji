package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressInfo {
    @SerializedName("fullAddress")
    @Expose
    private String fullAddress;
    @SerializedName("addressKey")
    @Expose
    private String addressKey;
    @SerializedName("roadAddressKey")
    @Expose
    private String roadAddressKey;
    @SerializedName("addressType")
    @Expose
    private String addressType;
    @SerializedName("city_do")
    @Expose
    private String cityDo;
    @SerializedName("gu_gun")
    @Expose
    private String guGun;
    @SerializedName("eup_myun")
    @Expose
    private String eupMyun;
    @SerializedName("adminDong")
    @Expose
    private String adminDong;
    @SerializedName("adminDongCode")
    @Expose
    private String adminDongCode;
    @SerializedName("legalDong")
    @Expose
    private String legalDong;
    @SerializedName("legalDongCode")
    @Expose
    private String legalDongCode;
    @SerializedName("ri")
    @Expose
    private String ri;
    @SerializedName("roadName")
    @Expose
    private String roadName;
    @SerializedName("buildingIndex")
    @Expose
    private String buildingIndex;
    @SerializedName("buildingName")
    @Expose
    private String buildingName;
    @SerializedName("mappingDistance")
    @Expose
    private String mappingDistance;
    @SerializedName("roadCode")
    @Expose
    private String roadCode;
    @SerializedName("bunji")
    @Expose
    private String bunji;
    @SerializedName("adminDongCoord")
    @Expose
    private AdminDongCoord adminDongCoord;
    @SerializedName("legalDongCoord")
    @Expose
    private LegalDongCoord legalDongCoord;
    @SerializedName("roadCoord")
    @Expose
    private RoadCoord roadCoord;

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getAddressKey() {
        return addressKey;
    }

    public void setAddressKey(String addressKey) {
        this.addressKey = addressKey;
    }

    public String getRoadAddressKey() {
        return roadAddressKey;
    }

    public void setRoadAddressKey(String roadAddressKey) {
        this.roadAddressKey = roadAddressKey;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
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

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getBuildingIndex() {
        return buildingIndex;
    }

    public void setBuildingIndex(String buildingIndex) {
        this.buildingIndex = buildingIndex;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getMappingDistance() {
        return mappingDistance;
    }

    public void setMappingDistance(String mappingDistance) {
        this.mappingDistance = mappingDistance;
    }

    public String getRoadCode() {
        return roadCode;
    }

    public void setRoadCode(String roadCode) {
        this.roadCode = roadCode;
    }

    public String getBunji() {
        return bunji;
    }

    public void setBunji(String bunji) {
        this.bunji = bunji;
    }

    public AdminDongCoord getAdminDongCoord() {
        return adminDongCoord;
    }

    public void setAdminDongCoord(AdminDongCoord adminDongCoord) {
        this.adminDongCoord = adminDongCoord;
    }

    public LegalDongCoord getLegalDongCoord() {
        return legalDongCoord;
    }

    public void setLegalDongCoord(LegalDongCoord legalDongCoord) {
        this.legalDongCoord = legalDongCoord;
    }

    public RoadCoord getRoadCoord() {
        return roadCoord;
    }

    public void setRoadCoord(RoadCoord roadCoord) {
        this.roadCoord = roadCoord;
    }
}
