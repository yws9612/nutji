package org.techtown.dontlate;

import android.app.TimePickerDialog;
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
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class alarmss extends Fragment {

    private View view;
    public static final int REQUEST_CODE1 = 1000;
    public static final int REQUEST_CODE2 = 1001;

    private AdapterActivity arrayAdapter;
    private Button tpBtn, removeBtn;
    private ListView listView;
    private TextView textView;
    private int hour, minute;
    private String month, day, am_pm;
    private Handler handler;
    private SimpleDateFormat mFormat;
    private int adapterPosition;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.alarms, container, false);

        arrayAdapter = new AdapterActivity();

        listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapterPosition = position;
                arrayAdapter.removeItem(position);
                Intent intent = new Intent(alarmss.getActivity(), TimePickerActivity.class);
                startActivityForResult(intent, REQUEST_CODE2);

            }
        });

        /*long now = System.currentTimeMillis();
        Date date new Date(now);*/

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Calendar cal = Calendar.getInstance();

                mFormat = new SimpleDateFormat("HH:mm:ss");
                String strTime = mFormat.format(cal.getTime());
                textView = (TextView) view.findViewById(R.id.current);
                textView.setTextSize(30);
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

        tpBtn = (Button) view.findViewById(R.id.addBtn);
        tpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tpIntent = new Intent(alarmss.getActivity(), TimePickerActivity.class);
                startActivityForResult(tpIntent, REQUEST_CODE1);
            }
        });

        removeBtn = (Button) view.findViewById(R.id.removeBtn);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayAdapter.removeItem();
                arrayAdapter.notifyDataSetChanged();
            }
        });


        protected void OnActivityResult( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE1 && resultCode == RESULT_OK && data != null) {
                hour = data.getIntExtra("hour", 1);
                minute = data.getIntExtra("minute", 2);
                am_pm = data.getStringExtra("am_pm");
                month = data.getStringExtra("month");
                day = data.getStringExtra("day");

                arrayAdapter.addItem(hour, minute, am_pm, month, day);
                arrayAdapter.notifyDataSetChanged();
            }

            if (requestCode == REQUEST_CODE2 && resultCode == RESULT_OK && data != null) {
                hour = data.getIntExtra("hour", 1);
                minute = data.getIntExtra("minute", 2);
                am_pm = data.getStringExtra("am_pm");
                month = data.getStringExtra("month");
                day = data.getStringExtra("day");

                arrayAdapter.addItem(hour, minute, am_pm, month, day);
                arrayAdapter.notifyDataSetChanged();
            }
        }
        return view;
    }
}
