package org.techtown.dontlate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.techtown.dontlate.R;

import java.util.ArrayList;

public class editSchedule extends AppCompatActivity {

    private ScheduleAdapter Sadapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView scheduleList;
    private ArrayList<ScheduleListItem> arrayList;

    private Button addbtn;
    private Button back;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    String day;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editschedule);

        scheduleList = (RecyclerView) findViewById(R.id.ScheduleList);
        addbtn = (Button) findViewById(R.id.addbtn);
        back = (Button) findViewById(R.id.back);

        Intent intent = getIntent();
        day = intent.getStringExtra("요일");

        scheduleList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        scheduleList.addItemDecoration(new DividerItemDecoration(this, 1));
        scheduleList.setLayoutManager(layoutManager);

        arrayList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Nutji").child("Schedule").child(day);

        Sadapter = new ScheduleAdapter(arrayList, this);
        scheduleList.setAdapter(Sadapter);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    ScheduleListItem scheduleListItem = snapshot.getValue(ScheduleListItem.class);
                    arrayList.add(scheduleListItem);
                }
                Sadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(editSchedule.this, addSchedule.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
