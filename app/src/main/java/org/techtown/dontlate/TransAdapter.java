package org.techtown.dontlate;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.TransViewHolder>{

    private ArrayList<Item> mList;
    private LayoutInflater mInflate;
    private Context mContext;

    public TransAdapter(Context context, ArrayList<Item> items) {
        this.mList = items;
        this.mInflate = LayoutInflater.from(context);
        this.mContext = context;
    }

    @NonNull
    @Override
    public TransViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = mInflate.inflate(R.layout.transportsitem, parent, false);
        TransViewHolder viewHolder = new TransViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransViewHolder holder, int position){
        //binding

        holder.stnNm.setText(mList.get(position).stnNm);
        holder.stationNm1.setText(mList.get(position).stationNm1);
        holder.rtNm.setText(mList.get(position).rtNm);
        holder.arrmsg1.setText(mList.get(position).arrmsg1);

    }

    @Override
    public int getItemCount(){
        return mList.size();
    }

    public static class TransViewHolder extends RecyclerView.ViewHolder {
        public TextView stnNm;
        public TextView rtNm;
        public TextView stationNm1;
        public TextView arrmsg1;


        public TransViewHolder(View itemView){
            super(itemView);

            stnNm = itemView.findViewById(R.id.tv_stnNm);
            rtNm = itemView.findViewById(R.id.tv_rtNm);
            stationNm1 = itemView.findViewById(R.id.tv_stationNm1);
            arrmsg1 = itemView.findViewById(R.id.tv_arrmsg1);

        }
    }
}
