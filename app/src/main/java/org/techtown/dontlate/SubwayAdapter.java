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
        return sList.size();
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


            gtTimes = subWayView.findViewById(R.id.tv_gtTimes);
            glsNames = subWayView.findViewById(R.id.tv_glsNames);
            gleNames = subWayView.findViewById(R.id.tv_gleNames);
            glsCounts = subWayView.findViewById(R.id.tv_glsCounts);
            adFares= subWayView.findViewById(R.id.tv_adFares);
            lnNames = subWayView.findViewById(R.id.tv_lnNames);
            sttNames = subWayView.findViewById(R.id.tv_sttNames);
            sttCounts = subWayView.findViewById(R.id.tv_sttCounts);
            waNames = subWayView.findViewById(R.id.tv_waNames);
        }
    }
}
