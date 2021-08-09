package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section {
    @SerializedName("graphPos")
    @Expose
    private List<GraphPos> graphPos = null;

    public List<GraphPos> getGraphPos() {
        return graphPos;
    }

    public void setGraphPos(List<GraphPos> graphPos) {
        this.graphPos = graphPos;
    }
}
