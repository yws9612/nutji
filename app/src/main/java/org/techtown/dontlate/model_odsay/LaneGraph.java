package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaneGraph {
    @SerializedName("class")
    @Expose
    private Integer _class;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("section")
    @Expose
    private List<Section> section = null;

    public Integer getClass_() {
        return _class;
    }

    public void setClass_(Integer _class) {
        this._class = _class;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }
}
