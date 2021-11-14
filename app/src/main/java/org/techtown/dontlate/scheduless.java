package org.techtown.dontlate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class scheduless extends Fragment {

    private View view;

    EditText et_user_name,et_user_email;
    Button btn_save;
    Button addbtn;
    String day;

    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.schedules, container, false);

        addbtn = (Button) view.findViewById(R.id.Addbtn);
//        et_user_name = view.findViewById(R.id.et_user_name);
//        et_user_email = view.findViewById(R.id.et_user_email);
//        btn_save = view.findViewById(R.id.btn_save);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        readUser();

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), editSchedule.class);
                final String[] items = new String[]{"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("요일을 선택하세요");
                builder.setItems(items, (dialog, pos) -> {
                    String selectedText = items[pos];
                    if(selectedText.equals("월요일")){
                        intent.putExtra( "요일", "월요일");
                        startActivity(intent);
                    }
                    else if(selectedText.equals("화요일")){
                        intent.putExtra( "요일", "화요일");
                        startActivity(intent);
                    }
                    else if(selectedText.equals("수요일")){
                        intent.putExtra( "요일", "수요일");
                        startActivity(intent);
                    }
                    else if(selectedText.equals("목요일")){
                        intent.putExtra( "요일", "목요일");
                        startActivity(intent);
                    }
                    else if(selectedText.equals("금요일")){
                        intent.putExtra( "요일", "금요일");
                        startActivity(intent);
                    }
                    else if(selectedText.equals("토요일")){
                        intent.putExtra( "요일", "토요일");
                        startActivity(intent);
                    }
                    else if(selectedText.equals("일요일")){
                        intent.putExtra( "요일", "일요일");
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });

//        btn_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String getUserName = et_user_name.getText().toString();
//                String getUserEmail = et_user_email.getText().toString();
//
//                //hashmap 만들기
//                HashMap result = new HashMap<>();
//                result.put("name", getUserName);
//                result.put("email", getUserEmail);
//
//                writeNewUser("1",getUserName,getUserEmail);
//            }
//        });
//
//    }
//
//    private void writeNewUser(String userId, String name, String email) {
//        User user = new User(name, email);
//
//        mDatabase.child("users").child(userId).setValue(user)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        // Write was successful!
//                        Toast.makeText(getContext(), "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Write failed
//                        Toast.makeText(getContext(), "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }
//    private void readUser(){
//        mDatabase.child("users").child("1").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                if(dataSnapshot.getValue(User.class) != null){
//                    User post = dataSnapshot.getValue(User.class);
//                    Log.w("FireBaseData", "getData" + post.toString());
//                } else {
//                    Toast.makeText(getContext(), "데이터 없음...", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w("FireBaseData", "loadPost:onCancelled", databaseError.toException());
//            }
//        });

        return view;
    }
}


