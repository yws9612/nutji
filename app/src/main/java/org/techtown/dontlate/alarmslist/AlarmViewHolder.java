package org.techtown.dontlate.alarmslist;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.dontlate.R;
import org.techtown.dontlate.data.Alarm;



public class AlarmViewHolder extends RecyclerView.ViewHolder {
    private TextView alarmTime;
    private ImageView alarmRecurring;
    private TextView alarmRecurringDays;
    private TextView alarmTitle;
    private TextView alarmMemo;
    private TextView AM_PM;

    Switch alarmStarted;

    private OnToggleAlarmListener listener;

    public AlarmViewHolder(@NonNull View itemView, OnToggleAlarmListener listener) {
        super(itemView);

        alarmTime = itemView.findViewById(R.id.item_alarm_time);
        alarmStarted = itemView.findViewById(R.id.item_alarm_started);
        alarmRecurringDays = itemView.findViewById(R.id.item_alarm_recurringDays);
        alarmTitle = itemView.findViewById(R.id.item_alarm_title);
        alarmMemo = itemView.findViewById(R.id.item_alarm_memo);
        AM_PM = itemView.findViewById(R.id.show_am_pm);

        this.listener = listener;

    }

    public void bind(Alarm alarm) {
        String alarmText;
        if(alarm.getHour()>12){
            int hour = alarm.getHour() - 12;
            alarmText = String.format("%02d : %02d", hour, alarm.getMinute());
            AM_PM.setText("오후");
        } else{
            alarmText = String.format("%02d : %02d", alarm.getHour(), alarm.getMinute());
            AM_PM.setText("오전");
        }

        alarmTime.setText(alarmText);
        alarmStarted.setChecked(alarm.isStarted());

        if (alarm.isRecurring()) {
            alarmRecurringDays.setText(alarm.getRecurringDaysText());
        } else {
            alarmRecurringDays.setText("한번만 울림");
        }

        if (alarm.getTitle().length() != 0) {
            alarmTitle.setText(String.format("%s", alarm.getTitle()));
        } else {
            alarmTitle.setText(String.format("%s", "알람"));
        }

        if(alarm.getMemo().length() != 0){
            alarmMemo.setText(String.format("%s",alarm.getMemo()));
        } else{
            alarmMemo.setText(String.format(""));
        }

        alarmStarted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listener.onToggle(alarm);
            }
        });
    }
}
