package org.techtown.dontlate;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class DiffCallback extends DiffUtil.Callback {

    private final List<UserListItem> OldList;
    private final List<UserListItem> NewList;

    public DiffCallback(List<UserListItem> oldList, List<UserListItem> newList) {
        this.OldList = oldList;
        this.NewList = newList;
    }

    @Override
    public int getOldListSize() {
        return OldList.size();
    }

    @Override
    public int getNewListSize() {
        return NewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return OldList.get(oldItemPosition).getplaceName()
                == NewList.get(newItemPosition).getplaceName();
    }

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final UserListItem oldlist = OldList.get(oldItemPosition);
        final UserListItem newlist = NewList.get(newItemPosition);

        return oldlist.getaddress().equals(newlist.getaddress());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItenPosition, int newItemPosition) {
        return super.getChangePayload(oldItenPosition, newItemPosition);
    }
}
