package org.techtown.dontlate;

import androidx.annotation.NonNull;
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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import net.daum.android.map.MapView;

import org.json.JSONException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //객체 추가

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

        Button btn = findViewById(R.id.test_button);
        bottomNavigationView = findViewById(R.id.bottomNavi);



        textView = findViewById(R.id.test_text);

        btn.setOnClickListener(this);
     /*   bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (menuItem.getItemId()) {
                    case R.id.알람드로어블파일:
                        setFrag(0);
                        break;
                    case R.id.네비게이션 드로어블파일:
                        setFrag(0);
                        break;
                    case R.id.시간표 드로어블파일:
                        setFrag(0);
                        break;
                    case R.id.대중교통 드로어블파일:
                        setFrag(0);
                        break;
                    case R.id.사용자 설정 드로어블파일:
                        setFrag(0);
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

        setFrag(1); //첫 Fragment 화면 지정




    }

    //Fragment 교체 발생 실행문
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.mainFrame, Alarmss);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.mainFrame, Navigationss);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.mainFrame, Scheduless);
                ft.commit();
                break;

            case 3:
                ft.replace(R.id.mainFrame, Transportss);
                ft.commit();
                break;

            case 4:
                ft.replace(R.id.mainFrame, Usersettingss);
                ft.commit();
                break;
        }
    }

    @Override//자바파일이름 선언
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test_button:
                PublicApi publicApi = new PublicApi();
                publicApi.apiTest(this, new PublicApi.OnSuccessListener() {
                    @Override
                    public void onRequestSuccess(String result) {
                        textView.setText(result);
                    }
                }); //api test 함수 실행구문
        }
    }

    



}



