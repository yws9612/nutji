package org.techtown.dontlate;

import android.view.View;
import android.widget.TextView;

public class ViewHolder {

    public TextView addressholder;

    public ViewHolder(View v)
    {
        v.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UserListAdapter.addressClickListener.onAddressClick(UserListItem.getaddress());
                // 여기서 Null 오브젝트가 왜 나와
            }
        });


        addressholder = v.findViewById(R.id.Address);
    }
}
