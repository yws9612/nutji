package org.techtown.dontlate.alarmslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.dontlate.R;
import org.techtown.dontlate.createalarm.CreateAlarmViewModel;
import org.techtown.dontlate.data.Alarm;

import java.util.ArrayList;
import java.util.List;


public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmViewHolder>  {

    List<Alarm> alarms;
    private OnToggleAlarmListener listener;
    private CreateAlarmViewModel createAlarmViewModel;



    public AlarmRecyclerViewAdapter(OnToggleAlarmListener listener) {
        this.alarms = new ArrayList<Alarm>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false);
        AlarmRecyclerViewAdapter.ViewHolder vholder = new ViewHolder(itemView);
        return new AlarmViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int position) {
        Alarm alarm = alarms.get(position);
        holder.bind(alarm);
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public void setAlarms(List<Alarm> alarms) {
        this.alarms = alarms;
        notifyDataSetChanged();
    }

    @Override
    public void onViewRecycled(@NonNull AlarmViewHolder holder) {
        super.onViewRecycled(holder);
        holder.alarmStarted.setOnCheckedChangeListener(null);
    }

    public void removeItem(int position){
        alarms.remove(position);
        notifyItemRemoved(position);
        //갱신처리 반드시 해야함
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout cardView;
        TextView alarmTime;
        ImageView alarmRecurring;
        TextView alarmRecurringDays;
        TextView alarmTitle;
        TextView alarmMemo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            alarmTime = itemView.findViewById(R.id.item_alarm_time);
            alarmRecurringDays = itemView.findViewById(R.id.item_alarm_recurringDays);
            alarmTitle = itemView.findViewById(R.id.item_alarm_title);
            alarmMemo = itemView.findViewById(R.id.item_alarm_memo);

            itemView.setOnLongClickListener(v -> {
                Alarm alarm = alarms.get(getAdapterPosition()+1);
                int alarmid = alarm.getAlarmId();
                createAlarmViewModel.delete(alarmid);
                return true;
            });
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "알람 선택", Toast.LENGTH_SHORT).show();
        }
    }

}

