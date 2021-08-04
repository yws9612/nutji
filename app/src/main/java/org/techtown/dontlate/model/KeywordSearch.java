package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KeywordSearch {
    @SerializedName("same_name")
    @Expose
    private SameName sameName;
    @SerializedName("documents")
    @Expose
    private List<KeywordSearchItems> keywordSearchItems;

    public SameName getSameName() {
        return sameName;
    }

    public void setSameName(SameName sameName) {
        this.sameName = sameName;
    }

    public List<KeywordSearchItems> getKeywordSearchItems() {
        return keywordSearchItems;
    }

    public void setDocuments(List<KeywordSearchItems> keywordSearchItems) {
        this.keywordSearchItems = keywordSearchItems;
    }

}
