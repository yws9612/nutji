package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReverseGeocoding {
    @SerializedName("addressInfo")
    @Expose
    private AddressInfo addressInfo;

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }
}
