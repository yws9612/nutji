package org.techtown.dontlate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;

    private alarmss Alarmss;
    private navigationss Navigationss;
    private scheduless Scheduless;
    private transportss Transportss;
    private usersettingss Usersettingss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
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

}