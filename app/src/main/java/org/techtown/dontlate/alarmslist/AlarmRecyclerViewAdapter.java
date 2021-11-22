package org.techtown.dontlate.alarmslist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.dontlate.R;
import org.techtown.dontlate.createalarm.CreateAlarmViewModel;
import org.techtown.dontlate.data.Alarm;
import org.techtown.dontlate.data.AlarmRepository;

import java.util.ArrayList;
import java.util.List;


public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmViewHolder>  {

    List<Alarm> alarms;
    private OnToggleAlarmListener listener;
    private CreateAlarmViewModel createAlarmViewModel;
    private int position = 0;
    AlarmRepository alarmrepo;
    private long created;

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
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int pos) {
        Alarm alarm = alarms.get(pos);
        holder.bind(alarm);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                position = holder.getAdapterPosition();
                System.out.println(position);
                removeItem(position);
                created = alarm.getCreated();
                createAlarmViewModel.delete(created);
                return true;
            }
        });

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




    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout cardView;
        TextView alarmTime;
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

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    v.setBackgroundColor(Color.BLACK);
                    return false;
                }
            });

        }

    }

}

