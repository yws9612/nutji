package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pous {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pkey")
    @Expose
    private String pkey;
    @SerializedName("navSeq")
    @Expose
    private String navSeq;
    @SerializedName("collectionType")
    @Expose
    private String collectionType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("telNo")
    @Expose
    private String telNo;
    @SerializedName("frontLat")
    @Expose
    private String frontLat;
    @SerializedName("frontLon")
    @Expose
    private String frontLon;
    @SerializedName("noorLat")
    @Expose
    private String noorLat;
    @SerializedName("noorLon")
    @Expose
    private String noorLon;
    @SerializedName("upperAddrName")
    @Expose
    private String upperAddrName;
    @SerializedName("middleAddrName")
    @Expose
    private String middleAddrName;
    @SerializedName("lowerAddrName")
    @Expose
    private String lowerAddrName;
    @SerializedName("detailAddrname")
    @Expose
    private String detailAddrname;
    @SerializedName("mlClass")
    @Expose
    private String mlClass;
    @SerializedName("firstNo")
    @Expose
    private String firstNo;
    @SerializedName("secondNo")
    @Expose
    private String secondNo;
    @SerializedName("roadName")
    @Expose
    private String roadName;
    @SerializedName("firstBuildNo")
    @Expose
    private String firstBuildNo;
    @SerializedName("secondBuildNo")
    @Expose
    private String secondBuildNo;
    @SerializedName("radius")
    @Expose
    private String radius;
    @SerializedName("upperBizName")
    @Expose
    private String upperBizName;
    @SerializedName("middleBizName")
    @Expose
    private String middleBizName;
    @SerializedName("lowerBizName")
    @Expose
    private String lowerBizName;
    @SerializedName("detailBizName")
    @Expose
    private String detailBizName;
    @SerializedName("rpFlag")
    @Expose
    private String rpFlag;
    @SerializedName("groupSubLists")
    @Expose
    private GroupSubLists groupSubLists;
    @SerializedName("newAddressList")
    @Expose
    private NewAddressList newAddressList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getFrontLat() {
        return frontLat;
    }

    public void setFrontLat(String frontLat) {
        this.frontLat = frontLat;
    }

    public String getFrontLon() {
        return frontLon;
    }

    public void setFrontLon(String frontLon) {
        this.frontLon = frontLon;
    }

    public String getNoorLat() {
        return noorLat;
    }

    public void setNoorLat(String noorLat) {
        this.noorLat = noorLat;
    }

    public String getNoorLon() {
        return noorLon;
    }

    public void setNoorLon(String noorLon) {
        this.noorLon = noorLon;
    }

    public String getUpperAddrName() {
        return upperAddrName;
    }

    public void setUpperAddrName(String upperAddrName) {
        this.upperAddrName = upperAddrName;
    }

    public String getMiddleAddrName() {
        return middleAddrName;
    }

    public void setMiddleAddrName(String middleAddrName) {
        this.middleAddrName = middleAddrName;
    }

    public String getLowerAddrName() {
        return lowerAddrName;
    }

    public void setLowerAddrName(String lowerAddrName) {
        this.lowerAddrName = lowerAddrName;
    }

    public String getDetailAddrname() {
        return detailAddrname;
    }

    public void setDetailAddrname(String detailAddrname) {
        this.detailAddrname = detailAddrname;
    }

    public String getMlClass() {
        return mlClass;
    }

    public void setMlClass(String mlClass) {
        this.mlClass = mlClass;
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

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getFirstBuildNo() {
        return firstBuildNo;
    }

    public void setFirstBuildNo(String firstBuildNo) {
        this.firstBuildNo = firstBuildNo;
    }

    public String getSecondBuildNo() {
        return secondBuildNo;
    }

    public void setSecondBuildNo(String secondBuildNo) {
        this.secondBuildNo = secondBuildNo;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getUpperBizName() {
        return upperBizName;
    }

    public void setUpperBizName(String upperBizName) {
        this.upperBizName = upperBizName;
    }

    public String getMiddleBizName() {
        return middleBizName;
    }

    public void setMiddleBizName(String middleBizName) {
        this.middleBizName = middleBizName;
    }

    public String getLowerBizName() {
        return lowerBizName;
    }

    public void setLowerBizName(String lowerBizName) {
        this.lowerBizName = lowerBizName;
    }

    public String getDetailBizName() {
        return detailBizName;
    }

    public void setDetailBizName(String detailBizName) {
        this.detailBizName = detailBizName;
    }

    public String getRpFlag() {
        return rpFlag;
    }

    public void setRpFlag(String rpFlag) {
        this.rpFlag = rpFlag;
    }

    public GroupSubLists getGroupSubLists() {
        return groupSubLists;
    }

    public void setGroupSubLists(GroupSubLists groupSubLists) {
        this.groupSubLists = groupSubLists;
    }

    public NewAddressList getNewAddressList() {
        return newAddressList;
    }

    public void setNewAddressList(NewAddressList newAddressList) {
        this.newAddressList = newAddressList;
    }
}
