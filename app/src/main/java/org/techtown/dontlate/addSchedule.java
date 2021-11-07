package org.techtown.dontlate;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class addSchedule extends AppCompatActivity {

    TextView hi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addschedule);

        hi = findViewById(R.id.HI);

    }
}
