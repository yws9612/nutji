package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TranslateAddressItems {
    @SerializedName("road_address")
    @Expose
    private RoadAddress roadAddress;
    @SerializedName("address")
    @Expose
    private Address address;

    public RoadAddress getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(RoadAddress roadAddress) {
        this.roadAddress = roadAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
