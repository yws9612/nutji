package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SearchingAddressItems {
    @SerializedName("address_name")
    @Expose
    private String addressName;
    @SerializedName("y")
    @Expose
    private String y;
    @SerializedName("x")
    @Expose
    private String x;
    @SerializedName("address_type")
    @Expose
    private String addressType;
    @SerializedName("address")
    @Expose
    private SearchingAddressAddress address;
    @SerializedName("road_address")
    @Expose
    private SearchingAddressRoadAddress roadAddress;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public SearchingAddressAddress getAddress() {
        return address;
    }

    public void setAddress(SearchingAddressAddress address) {
        this.address = address;
    }

    public SearchingAddressRoadAddress getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(SearchingAddressRoadAddress roadAddress) {
        this.roadAddress = roadAddress;
    }

}
