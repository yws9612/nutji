package org.techtown.dontlate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Begin_Arrived extends Activity {

    Button btn1;
    Spinner startSn,arriveSn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin_arrived);

        btn1 = (Button) findViewById(R.id.nextPage);
        startSn = (Spinner) findViewById(R.id.startSpinner);
        arriveSn = (Spinner) findViewById(R.id.arriveSpinner);

        ArrayAdapter locateAdapter = ArrayAdapter.createFromResource(this, R.array.locate,
                android.R.layout.simple_spinner_dropdown_item);

        locateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startSn.setAdapter(locateAdapter);
        arriveSn.setAdapter(locateAdapter);

        startSn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arriveSn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
