package org.techtown.dontlate;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> implements OnRecycleItemClickListener{

    private ArrayList<UserListItem> listItems = new ArrayList<UserListItem>();
    OnRecycleItemClickListener listener;


//    public UserListAdapter(ArrayList<UserListItem> list){
//        listItems = list;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView placeName;
        TextView address;

        ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, v, pos);

                        notifyDataSetChanged();
                    }
                }
            });

            placeName = itemView.findViewById(R.id.placeName);
            address = itemView.findViewById(R.id.Address);

        }
    }

    public void setOnItemClicklistener(OnRecycleItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item, parent, false);
        UserListAdapter.ViewHolder vh = new UserListAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {

        UserListItem item = listItems.get(position);

        holder.address.setText(item.getaddress());
        holder.placeName.setText(item.getplaceName());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void addItem(UserListItem item){
        listItems.add(item);
    }

    public void setItems(ArrayList<UserListItem> items){
        this.listItems = items;
    }

    public UserListItem getItem(int i) {
        return listItems.get(i);
    }

}

