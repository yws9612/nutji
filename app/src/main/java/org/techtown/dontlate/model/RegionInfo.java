package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionInfo {
    @SerializedName("regionId")
    @Expose
    private String regionId;
    @SerializedName("regionName")
    @Expose
    private String regionName;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("parentId")
    @Expose
    private String parentId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("properties")
    @Expose
    private Properties properties;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
