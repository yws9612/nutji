package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransAddress {
    @SerializedName("ConvertAdd")
    @Expose
    private ConvertAdd convertAdd;

    public ConvertAdd getConvertAdd() {
        return convertAdd;
    }

    public void setConvertAdd(ConvertAdd convertAdd) {
        this.convertAdd = convertAdd;
    }

}
