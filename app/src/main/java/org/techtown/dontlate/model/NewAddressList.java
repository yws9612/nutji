package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewAddressList {
    @SerializedName("newAddress")
    @Expose
    private List<NewAddress> newAddress = null;

    public List<NewAddress> getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(List<NewAddress> newAddress) {
        this.newAddress = newAddress;
    }
}
