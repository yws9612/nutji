package org.techtown.dontlate;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class addSchedule extends AppCompatActivity {

    private String starttime;
    private String endtime;
    private String day;
    private String active;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addschedule);

        EditText SCname = (EditText) findViewById(R.id.SCName);
        EditText SCmemo = (EditText) findViewById(R.id.SCMemo);

        Intent intent = getIntent();
        day = intent.getStringExtra("요일");

        TimePicker startpicker = (TimePicker) findViewById(R.id.startPicker);
        startpicker.setIs24HourView(true);
        startpicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                starttime = hour + ":" + min;
            }
        });

        TimePicker endpicker = (TimePicker) findViewById(R.id.endPicker);
        endpicker.setIs24HourView(true);
        endpicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                endtime = hour + ":" + min;
            }
        });

        Button okay = (Button) findViewById(R.id.Okay);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add_name = SCname.getText().toString();
                String add_memo = SCmemo.getText().toString();

                HashMap result = new HashMap<>();
                result.put("AlarmActive", active);
                result.put("EndTime", endtime);
                result.put("ScheduleName", add_name);
                result.put("ScheduleMemo", add_memo);
                result.put("StartTime", starttime);

                FirebaseDatabase.getInstance().getReference().child("Nutji").child("Schedule").child(day).child(add_name).setValue(result)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(addSchedule.this, "저장 완료", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent intent = new Intent(addSchedule.this, editSchedule.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button back = (Button) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        CheckBox check = (CheckBox) findViewById(R.id.Check);
        if(check.isChecked()) {
            active = "true";
        } else {
            active = "false";
        }
    }
}
