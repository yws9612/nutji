package org.techtown.dontlate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.odsay.odsayandroidsdk.API;
import com.odsay.odsayandroidsdk.ODsayData;
import com.odsay.odsayandroidsdk.ODsayService;
import com.odsay.odsayandroidsdk.OnResultCallbackListener;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;



import org.json.JSONException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity{ //객체 추가

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;

    private alarmss Alarmss;
    private navigationss Navigationss;
    private scheduless Scheduless;
    private transportss Transportss;
    private usersettingss Usersettingss;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn.setOnClickListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.alarm:
                        setFrag(0);
                        break;
                    case R.id.schedule:
                        setFrag(1);
                        break;
                    case R.id.transport:
                        setFrag(2);
                        break;
                    case R.id.navigation:
                        setFrag(3);
                        break;
                    case R.id.usersetting:
                        setFrag(4);
                        break;

                }
                return true;
            }
        });*/  //drawable에 ui 파일 필요

        Alarmss = new alarmss();
        Navigationss = new navigationss();
        Scheduless = new scheduless();
        Transportss = new transportss();
        Usersettingss = new usersettingss();


    }





}



