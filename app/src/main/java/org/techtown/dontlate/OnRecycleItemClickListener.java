package org.techtown.dontlate;
import android.view.View;

public interface OnRecycleItemClickListener {
    public void onItemClick(UserListAdapter.ViewHolder holder, View view, int position);
}
