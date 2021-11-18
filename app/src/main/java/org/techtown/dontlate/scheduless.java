package org.techtown.dontlate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class scheduless extends Fragment {

    private interface FirebaseCallback {
        void onCallback(List<String> listA, List<String> listB);
    }

    private View view;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private String weekDay;
    private String elementS;
    private String elementE;
    long time;

    ArrayList list1 = new ArrayList<ScheduleListItem>();
    ArrayList list2 = new ArrayList<ScheduleListItem>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.schedules, container, false);

        TextView test = view.findViewById(R.id.test);

        Button addbtn = view.findViewById(R.id.Addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), editSchedule.class);
                final String[] items = new String[]{"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("요일을 선택하세요");
                builder.setItems(items, (dialog, pos) -> {
                    String selectedText = items[pos];
                    if (selectedText.equals("월요일")) {
                        intent.putExtra("요일", "월요일");
                        startActivity(intent);
                    } else if (selectedText.equals("화요일")) {
                        intent.putExtra("요일", "화요일");
                        startActivity(intent);
                    } else if (selectedText.equals("수요일")) {
                        intent.putExtra("요일", "수요일");
                        startActivity(intent);
                    } else if (selectedText.equals("목요일")) {
                        intent.putExtra("요일", "목요일");
                        startActivity(intent);
                    } else if (selectedText.equals("금요일")) {
                        intent.putExtra("요일", "금요일");
                        startActivity(intent);
                    } else if (selectedText.equals("토요일")) {
                        intent.putExtra("요일", "토요일");
                        startActivity(intent);
                    } else if (selectedText.equals("일요일")) {
                        intent.putExtra("요일", "일요일");
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.KOREA);
        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        readData(new FirebaseCallback() {
            @Override
                public void onCallback(List<String> listA, List<String> listB) {

                for (int i=0; i<listA.size(); i++) {
                    elementS = listA.get(i);
                    elementE = listB.get(i);

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    Date inputsijak = null;
                    Date inputggut = null;

                    try {
                        inputsijak = simpleDateFormat.parse(elementS);
                        inputggut = simpleDateFormat.parse(elementE);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    long min = (inputggut.getTime() - inputsijak.getTime()) / (60 * 1000);
                    time = (min / 10);
                }
                // 여기서 테이블 동적 할당
            }
        });
        // time 여기로 나오면 또 0 된다

        return view;
    }

    public void readData(FirebaseCallback firebaseCallback) {
        databaseReference.child("Nutji").child("Schedule").child(weekDay).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String str1 = dataSnapshot.child("StartTime").getValue(String.class);
                    String str2 = dataSnapshot.child("EndTime").getValue(String.class);
                    list1.add(str1);
                    list2.add(str2);
                    firebaseCallback.onCallback(list1, list2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}


