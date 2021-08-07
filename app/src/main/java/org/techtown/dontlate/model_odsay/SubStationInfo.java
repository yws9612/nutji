package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubStationInfo {
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("stationID")
    @Expose
    private Integer stationID;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("laneName")
    @Expose
    private String laneName;
    @SerializedName("laneCity")
    @Expose
    private String laneCity;
    @SerializedName("CityCode")
    @Expose
    private Integer cityCode;
    @SerializedName("x")
    @Expose
    private Double x;
    @SerializedName("y")
    @Expose
    private Double y;
    @SerializedName("exOBJ")
    @Expose
    private ExOBJ exOBJ;
    @SerializedName("prevOBJ")
    @Expose
    private PrevOBJ prevOBJ;
    @SerializedName("nextOBJ")
    @Expose
    private NextOBJ nextOBJ;
    @SerializedName("defaultInfo")
    @Expose
    private DefaultInfo defaultInfo;
    @SerializedName("useInfo")
    @Expose
    private UseInfo useInfo;
    @SerializedName("exitInfo")
    @Expose
    private ExitInfo exitInfo;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getStationID() {
        return stationID;
    }

    public void setStationID(Integer stationID) {
        this.stationID = stationID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public String getLaneCity() {
        return laneCity;
    }

    public void setLaneCity(String laneCity) {
        this.laneCity = laneCity;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public ExOBJ getExOBJ() {
        return exOBJ;
    }

    public void setExOBJ(ExOBJ exOBJ) {
        this.exOBJ = exOBJ;
    }

    public PrevOBJ getPrevOBJ() {
        return prevOBJ;
    }

    public void setPrevOBJ(PrevOBJ prevOBJ) {
        this.prevOBJ = prevOBJ;
    }

    public NextOBJ getNextOBJ() {
        return nextOBJ;
    }

    public void setNextOBJ(NextOBJ nextOBJ) {
        this.nextOBJ = nextOBJ;
    }

    public DefaultInfo getDefaultInfo() {
        return defaultInfo;
    }

    public void setDefaultInfo(DefaultInfo defaultInfo) {
        this.defaultInfo = defaultInfo;
    }

    public UseInfo getUseInfo() {
        return useInfo;
    }

    public void setUseInfo(UseInfo useInfo) {
        this.useInfo = useInfo;
    }

    public ExitInfo getExitInfo() {
        return exitInfo;
    }

    public void setExitInfo(ExitInfo exitInfo) {
        this.exitInfo = exitInfo;
    }
}
