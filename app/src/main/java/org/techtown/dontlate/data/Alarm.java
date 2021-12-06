package org.techtown.dontlate.data;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver;

import java.util.Calendar;

import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.FRIDAY;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.MONDAY;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.Memo;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.RECURRING;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.SATURDAY;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.SUNDAY;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.THURSDAY;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.TITLE;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.TUESDAY;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.WEDNESDAY;



@Entity(tableName = "alarm_table")
public class Alarm {

    @PrimaryKey
    @NonNull
    private int alarmId;

    private int hour, minute;
    private boolean started, recurring;
    private boolean monday, tuesday, wednesday, thursday, friday, saturday, sunday;
    private String title;
    private String memo;

    private long created;

    public Alarm(int alarmId, int hour, int minute, String title,String memo, long created, boolean started, boolean recurring, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
        this.alarmId = alarmId;
        this.hour = hour;
        this.minute = minute;
        this.started = started;
        this.memo = memo;

        this.recurring = recurring;

        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;

        this.title = title;

        this.created = created;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isStarted() {
        return started;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public boolean isMonday() {
        return monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void schedule(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        intent.putExtra(RECURRING, recurring);
        intent.putExtra(MONDAY, monday);
        intent.putExtra(TUESDAY, tuesday);
        intent.putExtra(WEDNESDAY, wednesday);
        intent.putExtra(THURSDAY, thursday);
        intent.putExtra(FRIDAY, friday);
        intent.putExtra(SATURDAY, saturday);
        intent.putExtra(SUNDAY, sunday);

        intent.putExtra(TITLE, title);
        intent.putExtra(Memo, memo);

        PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(context, alarmId, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // if alarm time has already passed, increment day by 1
        if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        }

        if (!recurring) {
            String toastText = null;
            try {
                toastText = String.format("%s 알람이 %02d:%02d 에 울리도록 설정되었습니다.", title, hour, minute, alarmId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();

            alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    alarmPendingIntent
            );
        } else {
            String toastText = String.format("알람이 설정되었습니다.", title, getRecurringDaysText());
            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();

            final long RUN_DAILY = 24 * 60 * 60 * 1000;
            alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    RUN_DAILY,
                    alarmPendingIntent
            );
        }

        this.started = true;
    }

    public void cancelAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(context, alarmId, intent, 0);
        alarmManager.cancel(alarmPendingIntent);
        this.started = false;

        String toastText = String.format("알람이 취소되었습니다.");
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        Log.i("cancel", toastText);
    }

    //체크된 체크박스 확인하여 반복 요일 텍스트에 추가
    public String getRecurringDaysText() {
        if (!recurring) {
            return null;
        }

        String days = "";
        if (monday) {
            days += "월 ";
        }
        if (tuesday) {
            days += "화 ";
        }
        if (wednesday) {
            days += "수 ";
        }
        if (thursday) {
            days += "목 ";
        }
        if (friday) {
            days += "금 ";
        }
        if (saturday) {
            days += "토 ";
        }
        if (sunday) {
            days += "일 ";
        }

        return days;
    }

    public String getTitle() {
        return title;
    }

    public String getMemo() {return memo;}

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
