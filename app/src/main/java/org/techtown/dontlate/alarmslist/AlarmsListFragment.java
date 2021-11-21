package org.techtown.dontlate.alarmslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.dontlate.R;
import org.techtown.dontlate.TimePickerActivity;
import org.techtown.dontlate.data.Alarm;

import java.util.List;


public class AlarmsListFragment extends Fragment implements OnToggleAlarmListener {
    private AlarmRecyclerViewAdapter alarmRecyclerViewAdapter;
    private AlarmsListViewModel alarmsListViewModel;
    private RecyclerView alarmsRecyclerView;
    private Button addAlarm;


    FragmentManager fragmentManager = getFragmentManager();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alarmRecyclerViewAdapter = new AlarmRecyclerViewAdapter(this);
        alarmsListViewModel = ViewModelProviders.of(this).get(AlarmsListViewModel.class);
        alarmsListViewModel.getAlarmsLiveData().observe(this,
                new Observer<List<Alarm>>() {
                    @Override
                    public void onChanged(List<Alarm> alarms) {
                        if (alarms != null) {
                            alarmRecyclerViewAdapter.setAlarms(alarms);
                        }
                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_listalarms, container, false);

        alarmsRecyclerView = view.findViewById(R.id.fragment_listalarms_recylerView);
        alarmsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        alarmsRecyclerView.setAdapter(alarmRecyclerViewAdapter);


        addAlarm = view.findViewById(R.id.fragment_listalarms_addAlarm);
        addAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                v.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_alarmsListFragment_to_createAlarmFragment,null));
//                Navigation.findNavController(v).navigate(R.id.createAlarmFragment);
                Intent intent = new Intent(getActivity(), TimePickerActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public void onToggle(Alarm alarm) {
        if (alarm.isStarted()) {
            alarm.cancelAlarm(getContext());
            alarmsListViewModel.update(alarm);
        } else {
            alarm.schedule(getContext());
            alarmsListViewModel.update(alarm);
        }
    }
}