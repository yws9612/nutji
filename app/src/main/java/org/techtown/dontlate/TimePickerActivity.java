package org.techtown.dontlate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

public class TimePickerActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private Button okBtn, cancleBtn;
    private int hour, minute;
    private String am_pm;
    private Date currentTime;
    private String stMonth, stDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        timePicker = (TimePicker)findViewById(R.id.time_picker);

        currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat day = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat month = new SimpleDateFormat("MM", Locale.getDefault());

        stMonth = month.format(currentTime);
        stDay = day.format(currentTime);

        okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    hour = timePicker.getHour();
                    minute = timePicker.getMinute();
                }
                else {
                    hour = timePicker.getCurrentHour();
                    minute = timePicker.getCurrentMinute();
                }

                am_pm = AM_PM(hour);
                hour = timeSet(hour);

                Intent sendIntent = new Intent(TimePickerActivity.this, MainActivity.class);

                sendIntent.putExtra("hour", hour);
                sendIntent.putExtra("minute", minute);
                sendIntent.putExtra("am_pm", am_pm);
                sendIntent.putExtra("month", stMonth);
                sendIntent.putExtra("day", stDay);

                finish();
            }
        });

        cancleBtn = (Button) findViewById(R.id.cancleBtn);
        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private int timeSet(int hour) {
        if(hour > 12) {
            hour -= 12;
        }
        return hour;
    }

    private String AM_PM(int hour) {
        if (hour > 12) {
            am_pm = "오후";
        }
        else{
            am_pm = "오전";
        }
        return am_pm;
    }
}
