package org.techtown.dontlate;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubwayAdapter extends RecyclerView.Adapter<SubwayAdapter.SubwayViewHolder> {

    private ArrayList<SubwayItems> sList;
    private LayoutInflater sInflate;
    private Context sContext;

    public SubwayAdapter(Context context, ArrayList<SubwayItems> sitems){
        this.sList = sitems;
        this.sInflate = LayoutInflater.from(context);
        this.sContext = context;
    }

    @NonNull
    @Override
    public SubwayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = sInflate.inflate(R.layout.subwayitems, parent, false);
        SubwayViewHolder subwayViewHolder = new SubwayViewHolder(view);
        return subwayViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubwayViewHolder subwayViewHolder, int pos) {
        subwayViewHolder.gtTimes.setText(sList.get(pos).getGtTime());
        subwayViewHolder.glsNames.setText(sList.get(pos).getGlsName());
        subwayViewHolder.gleNames.setText(sList.get(pos).getGleName());
        subwayViewHolder.glsCounts.setText(sList.get(pos).getGlsCount());
        subwayViewHolder.adFares.setText(sList.get(pos).getAdFare());
        subwayViewHolder.lnNames.setText(sList.get(pos).getLnNamee());
        subwayViewHolder.sttNames.setText(sList.get(pos).getSttName());
        subwayViewHolder.sttCounts.setText(sList.get(pos).getSttCount());
        subwayViewHolder.waNames.setText(sList.get(pos).getWaName());




    }

    @Override
    public int getItemCount(){
        return (sList != null ? sList.size() : 0);
    }

    public static class SubwayViewHolder extends RecyclerView.ViewHolder{
        public TextView gtTimes;
        public TextView glsNames;
        public TextView gleNames;
        public TextView glsCounts;
        public TextView adFares;
        public TextView lnNames;
        public TextView sttNames;
        public TextView sttCounts;
        public TextView waNames;

        public SubwayViewHolder(View subWayView){
            super(subWayView);


            this.gtTimes = subWayView.findViewById(R.id.tv_gtTimes);
            this.glsNames = subWayView.findViewById(R.id.tv_glsNames);
            this.gleNames = subWayView.findViewById(R.id.tv_gleNames);
            this.glsCounts = subWayView.findViewById(R.id.tv_glsCounts);
            this.adFares= subWayView.findViewById(R.id.tv_adFares);
            this.lnNames = subWayView.findViewById(R.id.tv_lnNames);
            this.sttNames = subWayView.findViewById(R.id.tv_sttNames);
            this.sttCounts = subWayView.findViewById(R.id.tv_sttCounts);
            this.waNames = subWayView.findViewById(R.id.tv_waNames);
        }
    }
}
