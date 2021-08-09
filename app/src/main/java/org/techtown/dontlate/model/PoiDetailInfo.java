package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PoiDetailInfo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("viewId")
    @Expose
    private String viewId;
    @SerializedName("dbKind")
    @Expose
    private String dbKind;
    @SerializedName("pkey")
    @Expose
    private String pkey;
    @SerializedName("navSeq")
    @Expose
    private String navSeq;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bizCatName ")
    @Expose
    private String bizCatName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("firstNo")
    @Expose
    private String firstNo;
    @SerializedName("secondNo")
    @Expose
    private String secondNo;
    @SerializedName("zipCode")
    @Expose
    private String zipCode;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("mlClass")
    @Expose
    private String mlClass;
    @SerializedName("lcdName")
    @Expose
    private String lcdName;
    @SerializedName("mcdName")
    @Expose
    private String mcdName;
    @SerializedName("scdName")
    @Expose
    private String scdName;
    @SerializedName("dcdName")
    @Expose
    private String dcdName;
    @SerializedName("bldAddr")
    @Expose
    private String bldAddr;
    @SerializedName("roadScdName")
    @Expose
    private String roadScdName;
    @SerializedName("roadName")
    @Expose
    private String roadName;
    @SerializedName("bldNo1")
    @Expose
    private String bldNo1;
    @SerializedName("bldNo2")
    @Expose
    private String bldNo2;
    @SerializedName("frontlat")
    @Expose
    private String frontlat;
    @SerializedName("frontlon")
    @Expose
    private String frontlon;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("menu1")
    @Expose
    private String menu1;
    @SerializedName("menu2")
    @Expose
    private String menu2;
    @SerializedName("menu3")
    @Expose
    private String menu3;
    @SerializedName("menu4")
    @Expose
    private String menu4;
    @SerializedName("menu5")
    @Expose
    private String menu5;
    @SerializedName("parkFlag")
    @Expose
    private String parkFlag;
    @SerializedName("twFlag")
    @Expose
    private String twFlag;
    @SerializedName("yaFlag")
    @Expose
    private String yaFlag;
    @SerializedName("homepageURL")
    @Expose
    private String homepageURL;
    @SerializedName("routeInfo")
    @Expose
    private String routeInfo;
    @SerializedName("facility")
    @Expose
    private String facility;
    @SerializedName("upperLegalCode")
    @Expose
    private String upperLegalCode;
    @SerializedName("middleLegalCode")
    @Expose
    private String middleLegalCode;
    @SerializedName("lowerLegalCode")
    @Expose
    private String lowerLegalCode;
    @SerializedName("detailLegalCode")
    @Expose
    private String detailLegalCode;
    @SerializedName("upperAdminCode")
    @Expose
    private String upperAdminCode;
    @SerializedName("middleAdminCode")
    @Expose
    private String middleAdminCode;
    @SerializedName("lowerAdminCode")
    @Expose
    private String lowerAdminCode;
    @SerializedName("upperCode")
    @Expose
    private String upperCode;
    @SerializedName("middleCode")
    @Expose
    private String middleCode;
    @SerializedName("lowerCode")
    @Expose
    private String lowerCode;
    @SerializedName("point")
    @Expose
    private String point;
    @SerializedName("merchantDispType")
    @Expose
    private String merchantDispType;
    @SerializedName("merchantFlag")
    @Expose
    private String merchantFlag;
    @SerializedName("additionalInfo")
    @Expose
    private String additionalInfo;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("mngName")
    @Expose
    private String mngName;
    @SerializedName("mngId")
    @Expose
    private String mngId;
    @SerializedName("freeYn")
    @Expose
    private String freeYn;
    @SerializedName("reservYn")
    @Expose
    private String reservYn;
    @SerializedName("useTime")
    @Expose
    private String useTime;
    @SerializedName("payYn")
    @Expose
    private String payYn;
    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("updateDt")
    @Expose
    private String updateDt;
    @SerializedName("totalCnt")
    @Expose
    private String totalCnt;
    @SerializedName("evChargers")
    @Expose
    private List<EvCharger> evChargers = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getDbKind() {
        return dbKind;
    }

    public void setDbKind(String dbKind) {
        this.dbKind = dbKind;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String getNavSeq() {
        return navSeq;
    }

    public void setNavSeq(String navSeq) {
        this.navSeq = navSeq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBizCatName() {
        return bizCatName;
    }

    public void setBizCatName(String bizCatName) {
        this.bizCatName = bizCatName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstNo() {
        return firstNo;
    }

    public void setFirstNo(String firstNo) {
        this.firstNo = firstNo;
    }

    public String getSecondNo() {
        return secondNo;
    }

    public void setSecondNo(String secondNo) {
        this.secondNo = secondNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMlClass() {
        return mlClass;
    }

    public void setMlClass(String mlClass) {
        this.mlClass = mlClass;
    }

    public String getLcdName() {
        return lcdName;
    }

    public void setLcdName(String lcdName) {
        this.lcdName = lcdName;
    }

    public String getMcdName() {
        return mcdName;
    }

    public void setMcdName(String mcdName) {
        this.mcdName = mcdName;
    }

    public String getScdName() {
        return scdName;
    }

    public void setScdName(String scdName) {
        this.scdName = scdName;
    }

    public String getDcdName() {
        return dcdName;
    }

    public void setDcdName(String dcdName) {
        this.dcdName = dcdName;
    }

    public String getBldAddr() {
        return bldAddr;
    }

    public void setBldAddr(String bldAddr) {
        this.bldAddr = bldAddr;
    }

    public String getRoadScdName() {
        return roadScdName;
    }

    public void setRoadScdName(String roadScdName) {
        this.roadScdName = roadScdName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getBldNo1() {
        return bldNo1;
    }

    public void setBldNo1(String bldNo1) {
        this.bldNo1 = bldNo1;
    }

    public String getBldNo2() {
        return bldNo2;
    }

    public void setBldNo2(String bldNo2) {
        this.bldNo2 = bldNo2;
    }

    public String getFrontlat() {
        return frontlat;
    }

    public void setFrontlat(String frontlat) {
        this.frontlat = frontlat;
    }

    public String getFrontlon() {
        return frontlon;
    }

    public void setFrontlon(String frontlon) {
        this.frontlon = frontlon;
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

    public String getMenu1() {
        return menu1;
    }

    public void setMenu1(String menu1) {
        this.menu1 = menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public void setMenu2(String menu2) {
        this.menu2 = menu2;
    }

    public String getMenu3() {
        return menu3;
    }

    public void setMenu3(String menu3) {
        this.menu3 = menu3;
    }

    public String getMenu4() {
        return menu4;
    }

    public void setMenu4(String menu4) {
        this.menu4 = menu4;
    }

    public String getMenu5() {
        return menu5;
    }

    public void setMenu5(String menu5) {
        this.menu5 = menu5;
    }

    public String getParkFlag() {
        return parkFlag;
    }

    public void setParkFlag(String parkFlag) {
        this.parkFlag = parkFlag;
    }

    public String getTwFlag() {
        return twFlag;
    }

    public void setTwFlag(String twFlag) {
        this.twFlag = twFlag;
    }

    public String getYaFlag() {
        return yaFlag;
    }

    public void setYaFlag(String yaFlag) {
        this.yaFlag = yaFlag;
    }

    public String getHomepageURL() {
        return homepageURL;
    }

    public void setHomepageURL(String homepageURL) {
        this.homepageURL = homepageURL;
    }

    public String getRouteInfo() {
        return routeInfo;
    }

    public void setRouteInfo(String routeInfo) {
        this.routeInfo = routeInfo;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getUpperLegalCode() {
        return upperLegalCode;
    }

    public void setUpperLegalCode(String upperLegalCode) {
        this.upperLegalCode = upperLegalCode;
    }

    public String getMiddleLegalCode() {
        return middleLegalCode;
    }

    public void setMiddleLegalCode(String middleLegalCode) {
        this.middleLegalCode = middleLegalCode;
    }

    public String getLowerLegalCode() {
        return lowerLegalCode;
    }

    public void setLowerLegalCode(String lowerLegalCode) {
        this.lowerLegalCode = lowerLegalCode;
    }

    public String getDetailLegalCode() {
        return detailLegalCode;
    }

    public void setDetailLegalCode(String detailLegalCode) {
        this.detailLegalCode = detailLegalCode;
    }

    public String getUpperAdminCode() {
        return upperAdminCode;
    }

    public void setUpperAdminCode(String upperAdminCode) {
        this.upperAdminCode = upperAdminCode;
    }

    public String getMiddleAdminCode() {
        return middleAdminCode;
    }

    public void setMiddleAdminCode(String middleAdminCode) {
        this.middleAdminCode = middleAdminCode;
    }

    public String getLowerAdminCode() {
        return lowerAdminCode;
    }

    public void setLowerAdminCode(String lowerAdminCode) {
        this.lowerAdminCode = lowerAdminCode;
    }

    public String getUpperCode() {
        return upperCode;
    }

    public void setUpperCode(String upperCode) {
        this.upperCode = upperCode;
    }

    public String getMiddleCode() {
        return middleCode;
    }

    public void setMiddleCode(String middleCode) {
        this.middleCode = middleCode;
    }

    public String getLowerCode() {
        return lowerCode;
    }

    public void setLowerCode(String lowerCode) {
        this.lowerCode = lowerCode;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getMerchantDispType() {
        return merchantDispType;
    }

    public void setMerchantDispType(String merchantDispType) {
        this.merchantDispType = merchantDispType;
    }

    public String getMerchantFlag() {
        return merchantFlag;
    }

    public void setMerchantFlag(String merchantFlag) {
        this.merchantFlag = merchantFlag;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMngName() {
        return mngName;
    }

    public void setMngName(String mngName) {
        this.mngName = mngName;
    }

    public String getMngId() {
        return mngId;
    }

    public void setMngId(String mngId) {
        this.mngId = mngId;
    }

    public String getFreeYn() {
        return freeYn;
    }

    public void setFreeYn(String freeYn) {
        this.freeYn = freeYn;
    }

    public String getReservYn() {
        return reservYn;
    }

    public void setReservYn(String reservYn) {
        this.reservYn = reservYn;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getPayYn() {
        return payYn;
    }

    public void setPayYn(String payYn) {
        this.payYn = payYn;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public String getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(String totalCnt) {
        this.totalCnt = totalCnt;
    }

    public List<EvCharger> getEvChargers() {
        return evChargers;
    }

    public void setEvChargers(List<EvCharger> evChargers) {
        this.evChargers = evChargers;
    }
}
