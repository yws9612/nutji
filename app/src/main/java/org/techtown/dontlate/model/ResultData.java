package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultData {
    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("linkPoints")
    @Expose
    private List<LinkPoint> linkPoints;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<LinkPoint> getLinkPoints() {
        return linkPoints;
    }

    public void setLinkPoints(List<LinkPoint> linkPoints) {
        this.linkPoints = linkPoints;
    }
}
