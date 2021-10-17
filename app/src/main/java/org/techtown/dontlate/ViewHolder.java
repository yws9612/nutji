package org.techtown.dontlate;

import android.view.View;
import android.widget.TextView;

public class ViewHolder {

    public TextView addressholder;

    public ViewHolder(View v) {
        addressholder = v.findViewById(R.id.Address);
    }
}
