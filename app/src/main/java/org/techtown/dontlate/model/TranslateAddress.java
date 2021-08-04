package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TranslateAddress {
    @SerializedName("documents")
    @Expose
    private List<TranslateAddressItems> translateAddressItems;

    public List<TranslateAddressItems> getTranslateAddressItems() {
        return translateAddressItems;
    }

    public void setTranslateAddressItems(List<TranslateAddressItems> translateAddressItems) {
        this.translateAddressItems = translateAddressItems;
    }
}
