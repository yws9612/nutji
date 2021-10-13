package org.techtown.dontlate;

import android.app.Activity;
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

public class usersettingss extends Fragment {

    private View view;
    Button btn1;
    EditText edit1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.usersettings, container, false);

        btn1 = (Button) view.findViewById(R.id.addplace);
        edit1 = (EditText) view.findViewById(R.id.place);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), addressSearch.class);
                getActivity().overridePendingTransition(0, 0);
                startActivityForResult(i, 10000);
            }
        });

        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.i("test", "onActivityResult");

        switch (requestCode) {
            case 10000:
                if (resultCode == Activity.RESULT_OK) {
                    String data = intent.getExtras().getString("data");
                    if (data != null) {
                        Log.i("test", "data:" + data);
                        edit1.setText(data);
                    }
                }
                break;
        }
    }
}
