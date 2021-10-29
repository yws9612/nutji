package org.techtown.dontlate;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<UserListItem> listItems = new ArrayList<UserListItem>();

    public UserListAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
            ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
            layoutParams.height = 100;
            convertView.setLayoutParams(layoutParams);

            return  convertView;
        }

        TextView placeName = (TextView)convertView.findViewById(R.id.placeName);
        TextView address = (TextView)convertView.findViewById(R.id.address);
        Button btnDelete = (Button)convertView.findViewById(R.id.btnDelete);

        UserListItem listItem = listItems.get(position);

        placeName.setText(listItem.getplaceName());
        address.setText(listItem.getaddress());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems.remove(position);
                notifyDataSetChanged();
            }
        });



        return  convertView;
    }

    public void addItem(String placeName, String address){
        UserListItem listItem = new UserListItem();

        listItem.setplaceName(placeName);
        listItem.setaddress(address);

        listItems.add(listItem);
    }

}
