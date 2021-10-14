package org.techtown.dontlate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupSubLists {
    @SerializedName("groupSub")
    @Expose
    private List<GroupSub> groupSub;

    public List<GroupSub> getGroupSub() {
        return groupSub;
    }

    public void setGroupSub(List<GroupSub> groupSub) {
        this.groupSub = groupSub;
    }
}
