package org.techtown.dontlate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import org.techtown.dontlate.createalarm.CreateAlarmViewModel;
import org.techtown.dontlate.createalarm.TimePickerUtil;
import org.techtown.dontlate.data.Alarm;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TimePickerActivity extends AppCompatActivity {

    //View 아이템 바인딩
    @BindView(R.id.fragment_createalarm_timePicker)
    TimePicker timePicker;
    @BindView(R.id.fragment_createalarm_recurring)
    CheckBox recurring;
    @BindView(R.id.fragment_createalarm_title)
    EditText title;
    @BindView(R.id.fragment_createalarm_checkMon)
    CheckBox mon;
    @BindView(R.id.fragment_createalarm_checkTue)
    CheckBox tue;
    @BindView(R.id.fragment_createalarm_checkWed)
    CheckBox wed;
    @BindView(R.id.fragment_createalarm_checkThu)
    CheckBox thu;
    @BindView(R.id.fragment_createalarm_checkFri)
    CheckBox fri;
    @BindView(R.id.fragment_createalarm_checkSat)
    CheckBox sat;
    @BindView(R.id.fragment_createalarm_checkSun)
    CheckBox sun;
    @BindView(R.id.fragment_createalarm_recurring_options)
    LinearLayout recurringOptions;
    @BindView(R.id.okBtn)
    Button okBtn;
    @BindView(R.id.backBtn)
    Button backBtn;
    @BindView(R.id.fragment_createalarm_memo)
    EditText memo;

    private CreateAlarmViewModel createAlarmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_createalarm);

        createAlarmViewModel = ViewModelProviders.of(this).get(CreateAlarmViewModel.class);

        ButterKnife.bind(this);

        recurring.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                recurringOptions.setVisibility(View.VISIBLE);
            } else {
                recurringOptions.setVisibility(View.GONE);
            }
        });

        okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mon.isChecked()||tue.isChecked()||wed.isChecked()||thu.isChecked()||fri.isChecked()||sat.isChecked()||sun.isChecked()) {
                    scheduleAlarm();
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(getApplicationContext(),"최소 1개의 요일을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //뒤로가기 버튼 터치 시 메인으로 복귀
        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    //휴대폰 뒤로가기버튼 터치 시 메인으로 복귀
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    
    //사용자가 선택한 요일, 시간, 제목, 메모를 입력받아 Alarm 객체 생성
    private void scheduleAlarm() {
        int alarmId = new Random().nextInt(Integer.MAX_VALUE);

        if(mon.isChecked()||tue.isChecked()||wed.isChecked()||thu.isChecked()||fri.isChecked()||sat.isChecked()||sun.isChecked()){

            Alarm alarm = new Alarm(
                    alarmId,
                    TimePickerUtil.getTimePickerHour(timePicker),
                    TimePickerUtil.getTimePickerMinute(timePicker),
                    title.getText().toString(),
                    memo.getText().toString(),
                    System.currentTimeMillis(),
                    true,
                    recurring.isChecked(),
                    mon.isChecked(),
                    tue.isChecked(),
                    wed.isChecked(),
                    thu.isChecked(),
                    fri.isChecked(),
                    sat.isChecked(),
                    sun.isChecked()
            );


            createAlarmViewModel.insert(alarm);

            alarm.schedule(getApplicationContext());

        } else {

        }




    }
}
