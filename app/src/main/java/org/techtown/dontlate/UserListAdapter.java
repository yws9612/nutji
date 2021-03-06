package org.techtown.dontlate;

import android.app.AlertDialog;
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

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> implements OnRecycleItemClickListener{

    private ArrayList<UserListItem> listItems;
    private OnRecycleItemClickListener listener;
    private Context mContext;

    public UserListAdapter(ArrayList<UserListItem> item, Context context) {
        this.listItems = item;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView placeName;
        TextView address;

        ViewHolder(View itemView) {
            super(itemView);

            placeName = itemView.findViewById(R.id.placeName);
            address = itemView.findViewById(R.id.Address);

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

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setMessage("선택한 항목을 삭제하시겠습니까?")
                            .setTitle("항목 삭제")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    int pos = getAdapterPosition();
                                    UserListItem item = listItems.get(pos);
                                    String name = item.getplaceName();

                                    FirebaseDatabase.getInstance().getReference().child("Nutji").child("User").child("Place").child(name).removeValue();

                                    listItems.remove(getAdapterPosition());

                                    notifyItemRemoved(pos);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();

                    return true;
                }

            });
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
        mContext = parent.getContext();
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
    public int getItemCount() { return (listItems != null ? listItems.size() : 0); }

    public void updateItems(List<UserListItem> itemss) {
        final DiffCallback callback = new DiffCallback(this.listItems, itemss);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);

        this.listItems.clear();
        this.listItems.addAll(itemss);
        diffResult.dispatchUpdatesTo(this);
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

