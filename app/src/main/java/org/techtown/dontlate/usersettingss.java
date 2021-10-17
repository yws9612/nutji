package org.techtown.dontlate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class usersettingss extends Fragment {

    private ListView listView;
    private UserListAdapter adapter;
    private TextView address;
    private List<UserListItem> ItemList;

    private Button addPlace;

    public interface AddressClickListener {
        void onAddressClick(String address);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.usersettings, container, false);

        addPlace = (Button) v.findViewById(R.id.addplace);
        listView = (ListView) v.findViewById(R.id.Listview);
        address = (TextView) v.findViewById(R.id.Address);

        adapter = new UserListAdapter(getActivity().getApplicationContext());
        listView.setAdapter(adapter);

        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = new String[]{"집", "회사", "학교"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("장소를 선택하세요")
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
                            public void onClick(DialogInterface dialogInterface, int which) {

                            }
                        }).create().show();

            }
        });

        return v;
    }

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Intent i = new Intent(getActivity().getApplicationContext(), addressSearch.class);
//                // 화면전환 애니메이션 없애기
//                getActivity().overridePendingTransition(0, 0);
//                // 주소결과
//                startActivityForResult(i, 10000);
//            }
//        });

        private void bindList() {
            adapter = new UserListAdapter(getContext());

            adapter.AddressClickListener(new AddressClickListener(){
                @Override
                public void onAddressClick(String address) {
                    Intent i = new Intent(getActivity().getApplicationContext(), addressSearch.class);
                    // 화면전환 애니메이션 없애기
                    getActivity().overridePendingTransition(0, 0);
                    // 주소결과
                    startActivityForResult(i, 10000);
                }
            });
        }


        public void onActivityResult(int requestCode, int resultCode, Intent i) {
            super.onActivityResult(requestCode, resultCode, i);
            Log.i("test", "onActivityResult");

            switch (requestCode) {
                case 10000:
                    if (resultCode == Activity.RESULT_OK) {
                        String data = i.getExtras().getString("data");
                        if (data != null) {
                            Log.i("test", "data:" + data);
                            address.setText(data);
                        }
                    }
                    break;
            }

        }


    }

