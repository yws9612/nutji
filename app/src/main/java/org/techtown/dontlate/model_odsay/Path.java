package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Path {
    @SerializedName("pathType")
    @Expose
    private Integer pathType;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("subPath")
    @Expose
    private List<SubPath> subPath = null;

    public Integer getPathType() {
        return pathType;
    }

    public void setPathType(Integer pathType) {
        this.pathType = pathType;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<SubPath> getSubPath() {
        return subPath;
    }

    public void setSubPath(List<SubPath> subPath) {
        this.subPath = subPath;
    }
}
