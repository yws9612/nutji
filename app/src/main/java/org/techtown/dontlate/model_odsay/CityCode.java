package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityCode {
    @SerializedName("CID")
    @Expose
    private List<CID> cid = null;

    public List<CID> getCid() {
        return cid;
    }

    public void setCid(List<CID> cid) {
        this.cid = cid;
    }
}
