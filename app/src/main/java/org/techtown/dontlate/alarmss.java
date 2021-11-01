package org.techtown.dontlate;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.app.Activity.RESULT_OK;
import static androidx.core.content.ContextCompat.getSystemService;

public class alarmss extends Fragment implements TimePickerDialog.OnTimeSetListener {

    public static final int REQUEST_CODE1 = 1000;
    public static final int REQUEST_CODE2 = 1001;
    private AdapterActivity arrayAdapter;
    private Button tpBtn, removeBtn;
    private ListView listView;
    private TextView textView;
    private int hour, minute;
    private String month,day,am_pm;
    private Handler handler;
    private SimpleDateFormat mFormat;
    private int adapterPosition;
    private  TextView mTextView;
    private View view;
    public static final int REQUEST_CODE3 = 1000;
    public static final int REQUEST_CODE4 = 1001;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.alarms, container, false);
        arrayAdapter = new AdapterActivity();

        listView = (ListView) view.findViewById(R.id.list_view);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            adapterPosition = position;
            arrayAdapter.removeItem(position);
            Intent intent = new Intent(getActivity(), TimePicker.class);
            startActivityForResult(intent, REQUEST_CODE2);
        });

        handler = new Handler() {
            public void handleMessage(@NonNull Message msg) {
                Calendar cal = Calendar.getInstance();

                mFormat = new SimpleDateFormat("HH:mm:ss");
                String strTime = mFormat.format(cal.getTime());
                textView = (TextView) view.findViewById(R.id.current1);
                textView.setTextSize(50);
                textView.setText(strTime);
            }
        };

        class NewRunnable implements Runnable {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(0);
                }
            }
        }

        NewRunnable runnable = new NewRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        tpBtn = (Button) view.findViewById(R.id.button_timepicker);
        tpBtn.setOnClickListener(v -> {
            Intent tpintent = new Intent(getActivity(), TimePickerActivity.class);
            startActivityForResult(tpintent, REQUEST_CODE3);
        });

//        removeBtn = (Button) view.findViewById(R.id.button_cancel);
//        removeBtn.setOnClickListener(v -> {
//            arrayAdapter.removeItem();
//            arrayAdapter.notifyDataSetChanged();
//        });
        return view;
    }

        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)    {
            super.onActivityResult(requestCode,resultCode,data);

            if(requestCode == REQUEST_CODE3 && resultCode== RESULT_OK && data != null){
                hour = data.getIntExtra("hour",1);
                minute = data.getIntExtra("minute", 2);
                am_pm = data.getStringExtra("am_pm");
                month = data.getStringExtra("month");
                day = data.getStringExtra("day");

                arrayAdapter.addItem(hour, minute, am_pm, month, day);
                arrayAdapter.notifyDataSetChanged();
            }

            if(requestCode == REQUEST_CODE4 && resultCode == RESULT_OK && data != null) {
                hour = data.getIntExtra("hour", 1);
                minute = data.getIntExtra("minute", 2);
                am_pm = data.getStringExtra("am_pm");
                month = data.getStringExtra("month");
                day = data.getStringExtra("day");

                arrayAdapter.addItem(hour, minute, am_pm, month, day);
                arrayAdapter.notifyDataSetChanged();
            }
        }

        /*
        mTextView =  view.findViewById(R.id.textView);

        Button button = (Button) view.findViewById(R.id.button_timepicker);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getFragmentManager(), "time picker");
            }
        });


        Button buttonCancelAlarm = view.findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });*/



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

    /*
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
    }

    private void updateTimeText(Calendar c){
        String timeText = "다음 시간에 알람 설정 : ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }


    private void startAlarm(Calendar c){
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(),AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, 0);

        if(c.before((Calendar.getInstance()))){
            c.add(Calendar.DATE, 1);
        }
        //alarmManager.setExact(AlarmAct.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 1*60*1000 ,  pendingIntent);

    }

    private void cancelAlarm(){
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(),AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("알람이 삭제되었습니다.");
    }
    */
}






