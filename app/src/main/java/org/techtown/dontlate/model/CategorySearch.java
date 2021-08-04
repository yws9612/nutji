package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategorySearch {
    @SerializedName("same_name")
    @Expose
    private SameName sameName;
    @SerializedName("documents")
    @Expose
    private List<CategorySearchItems> categorySearchItems;

    public SameName getSameName() {
        return sameName;
    }

    public void setSameName(SameName sameName) {
        this.sameName = sameName;
    }

    public List<CategorySearchItems> getCategorySearchItems () {
        return categorySearchItems;
    }

    public void setCategorySearchItems (List < CategorySearchItems > categorySearchItems) {
        this.categorySearchItems = categorySearchItems;
    }
}

