package org.techtown.dontlate;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;


public class addPlace extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addplace);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
