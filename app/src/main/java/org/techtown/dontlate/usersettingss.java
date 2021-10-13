package org.techtown.dontlate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class usersettingss extends Fragment {

    private ListView listView;
    private UserListAdapter adapter;

    private Button addPlace;

    @Nullable
    //@Override
    public void onCreate(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.usersettings, container, false);
        //setContentView(R.layout.usersettings);

        addPlace = (Button) v.findViewById(R.id.addplace);
        listView = (ListView) v.findViewById(R.id.listview);

        //adapter = new UserListAdapter(usersettingss.this);
        listView.setAdapter(adapter);

    }

}
