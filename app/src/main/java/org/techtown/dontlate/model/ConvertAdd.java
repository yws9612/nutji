package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConvertAdd {
    @SerializedName("resCount")
    @Expose
    private String resCount;
    @SerializedName("resMulti")
    @Expose
    private String resMulti;
    @SerializedName("reqAddress")
    @Expose
    private String reqAddress;
    @SerializedName("upperDistCode")
    @Expose
    private String upperDistCode;
    @SerializedName("upperDistName")
    @Expose
    private String upperDistName;
    @SerializedName("middleDistCode")
    @Expose
    private String middleDistCode;
    @SerializedName("middleDistName")
    @Expose
    private String middleDistName;
    @SerializedName("legalLowerDistCode")
    @Expose
    private String legalLowerDistCode;
    @SerializedName("legalLowerDistName")
    @Expose
    private String legalLowerDistName;
    @SerializedName("legalDetailCode")
    @Expose
    private String legalDetailCode;
    @SerializedName("legalDetailName")
    @Expose
    private String legalDetailName;
    @SerializedName("adminLowerDistCode")
    @Expose
    private String adminLowerDistCode;
    @SerializedName("adminDistName")
    @Expose
    private String adminDistName;
    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("secondary")
    @Expose
    private String secondary;
    @SerializedName("mlClass")
    @Expose
    private String mlClass;
    @SerializedName("oldLat")
    @Expose
    private String oldLat;
    @SerializedName("oldLon")
    @Expose
    private String oldLon;
    @SerializedName("newAddressList")
    @Expose
    private NewAddressList newAddressList;

    public String getResCount() {
        return resCount;
    }

    public void setResCount(String resCount) {
        this.resCount = resCount;
    }

    public String getResMulti() {
        return resMulti;
    }

    public void setResMulti(String resMulti) {
        this.resMulti = resMulti;
    }

    public String getReqAddress() {
        return reqAddress;
    }

    public void setReqAddress(String reqAddress) {
        this.reqAddress = reqAddress;
    }

    public String getUpperDistCode() {
        return upperDistCode;
    }

    public void setUpperDistCode(String upperDistCode) {
        this.upperDistCode = upperDistCode;
    }

    public String getUpperDistName() {
        return upperDistName;
    }

    public void setUpperDistName(String upperDistName) {
        this.upperDistName = upperDistName;
    }

    public String getMiddleDistCode() {
        return middleDistCode;
    }

    public void setMiddleDistCode(String middleDistCode) {
        this.middleDistCode = middleDistCode;
    }

    public String getMiddleDistName() {
        return middleDistName;
    }

    public void setMiddleDistName(String middleDistName) {
        this.middleDistName = middleDistName;
    }

    public String getLegalLowerDistCode() {
        return legalLowerDistCode;
    }

    public void setLegalLowerDistCode(String legalLowerDistCode) {
        this.legalLowerDistCode = legalLowerDistCode;
    }

    public String getLegalLowerDistName() {
        return legalLowerDistName;
    }

    public void setLegalLowerDistName(String legalLowerDistName) {
        this.legalLowerDistName = legalLowerDistName;
    }

    public String getLegalDetailCode() {
        return legalDetailCode;
    }

    public void setLegalDetailCode(String legalDetailCode) {
        this.legalDetailCode = legalDetailCode;
    }

    public String getLegalDetailName() {
        return legalDetailName;
    }

    public void setLegalDetailName(String legalDetailName) {
        this.legalDetailName = legalDetailName;
    }

    public String getAdminLowerDistCode() {
        return adminLowerDistCode;
    }

    public void setAdminLowerDistCode(String adminLowerDistCode) {
        this.adminLowerDistCode = adminLowerDistCode;
    }

    public String getAdminDistName() {
        return adminDistName;
    }

    public void setAdminDistName(String adminDistName) {
        this.adminDistName = adminDistName;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getMlClass() {
        return mlClass;
    }

    public void setMlClass(String mlClass) {
        this.mlClass = mlClass;
    }

    public String getOldLat() {
        return oldLat;
    }

    public void setOldLat(String oldLat) {
        this.oldLat = oldLat;
    }

    public String getOldLon() {
        return oldLon;
    }

    public void setOldLon(String oldLon) {
        this.oldLon = oldLon;
    }

    public NewAddressList getNewAddressList() {
        return newAddressList;
    }

    public void setNewAddressList(NewAddressList newAddressList) {
        this.newAddressList = newAddressList;
    }
}
