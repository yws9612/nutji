package org.techtown.dontlate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterActivity extends BaseAdapter {
    public ArrayList<Time> listviewitem = new ArrayList<Time>();
    private ArrayList<Time> arrayList = listviewitem;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemID(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecyclerView.ViewHolder holder;
        if(convertView ==null){
            holder = new ViewHolder
        }
    }
}
