package org.techtown.dontlate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.usersettings, container, false);

        addPlace = (Button) v.findViewById(R.id.addplace);
        listView = (ListView) v.findViewById(R.id.Listview);

        adapter = new UserListAdapter(getActivity().getApplicationContext());
        listView.setAdapter(adapter);

        addPlace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String[] items = new String[] {"집", "회사", "학교"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog .setTitle("장소를 선택하세요")
                        .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String Place = items[which];
                                adapter.addItem(Place, "클릭하세요");
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create().show();


            }
        });

        return v;
    }

}
