package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchingAddress {
    @SerializedName("documents")
    @Expose
    private List<SearchingAddressItems> searchingAddressItems;

    public List<SearchingAddressItems> getSearchingAddressItems() {
        return searchingAddressItems;
    }

    public void setSearchingAddressItems(List<SearchingAddressItems> searchingAddressItems) {
        this.searchingAddressItems = searchingAddressItems;
    }
}
