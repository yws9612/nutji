package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TranslateCoord {
    @SerializedName("documents")
    @Expose
    private List<TranslateCoordItems> translateCoordItems;

    public List<TranslateCoordItems> getTranslateCoordItems() {
        return translateCoordItems;
    }

    public void setTranslateCoordItems(List<TranslateCoordItems> translateCoordItems) {
        this.translateCoordItems = translateCoordItems;
    }
}
