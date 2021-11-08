package org.techtown.dontlate;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SelectJob extends AppCompatActivity {

    private DatabaseReference mDatabase;
    Button student, college, worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        student = (Button) findViewById(R.id.student);
        college = (Button) findViewById(R.id.college);
        worker = (Button) findViewById(R.id.worker);

//        student.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String getUsersJob = "중/고등학생";
//
//                HashMap result = new HashMap<>();
//                result.put("Job", getUsersJob);
//
//                writeNewUser("1", getUsersJob);
//                finish();
//            }
//        });
//
//        college.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String getUsersJob = "대학생";
//
//                HashMap result = new HashMap<>();
//                result.put("Job", getUsersJob);
//
//                writeNewUser("1", getUsersJob);
//                finish();
//            }
//        });
//
//        worker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String getUsersJob = "직장인";
//
//                HashMap result = new HashMap<>();
//                result.put("Job", getUsersJob);
//
//                writeNewUser("1", getUsersJob);
//                finish();
//            }
//        });
//    }
//
//    private void writeNewUser(String userId, String job) {
//        UsersJob usersJob = new UsersJob(job);
//
//        mDatabase.child("users").child(userId).setValue(usersJob)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        // Write was successful!
//                        Toast.makeText(SelectJob.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Write failed
//                        Toast.makeText(SelectJob.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }
    }
}
