package org.techtown.dontlate.model_odsay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriveInfoSet {
    @SerializedName("driveInfo")
    @Expose
    private List<DriveInfo> driveInfo = null;

    public List<DriveInfo> getDriveInfo() {
        return driveInfo;
    }

    public void setDriveInfo(List<DriveInfo> driveInfo) {
        this.driveInfo = driveInfo;
    }

}
