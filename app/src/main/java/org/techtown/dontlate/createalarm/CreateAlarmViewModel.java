package org.techtown.dontlate.createalarm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.techtown.dontlate.data.Alarm;
import org.techtown.dontlate.data.AlarmRepository;

//알람 생성,삭제 조작
public class CreateAlarmViewModel extends AndroidViewModel {
    private AlarmRepository alarmRepository;

    public CreateAlarmViewModel(@NonNull Application application) {
        super(application);

        alarmRepository = new AlarmRepository(application);
    }

    public void insert(Alarm alarm) {
        alarmRepository.insert(alarm);
    }

    public void delete(Alarm alarm) { alarmRepository.delete(alarm);}

}
