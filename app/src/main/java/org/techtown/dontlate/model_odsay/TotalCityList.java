package org.techtown.dontlate.model_odsay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TotalCityList {
    @SerializedName("includeCity")
    @Expose
    private List<IncludeCity> includeCity = null;

    public List<IncludeCity> getIncludeCity() {
        return includeCity;
    }

    public void setIncludeCity(List<IncludeCity> includeCity) {
        this.includeCity = includeCity;
    }
}
