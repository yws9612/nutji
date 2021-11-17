package org.techtown.dontlate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.techtown.dontlate.alarmslist.AlarmsListFragment;

public class MainActivity extends AppCompatActivity { //객체 추가  implements View.OnClickListener

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private AlarmsListFragment Alarmss;
//    private alarmss Alarmss;

    private navigationss Navigationss;
    private scheduless Scheduless;
    private transportss Transportss;
    private usersettingss Usersettingss;
    private TextView textView;



    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button btn = findViewById(R.id.test_button);
        bottomNavigationView = findViewById(R.id.bottomNavi);
        menu=bottomNavigationView.getMenu();


        //textView = findViewById(R.id.test_text);

        //btn.setOnClickListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.alarm:
                        menuItem.setIcon(R.drawable.manage_click);
                        menu.findItem(R.id.schedule).setIcon(R.drawable.schedule);
                        menu.findItem(R.id.transport).setIcon(R.drawable.bus);
                        menu.findItem(R.id.navigation).setIcon(R.drawable.taxi);
                        menu.findItem(R.id.usersetting).setIcon(R.drawable.profile);
                        setFrag(0);
                        break;

                    case R.id.schedule:
                        menuItem.setIcon(R.drawable.schedule_click);
                        menu.findItem(R.id.navigation).setIcon(R.drawable.taxi);
                        menu.findItem(R.id.transport).setIcon(R.drawable.bus);
                        menu.findItem(R.id.alarm).setIcon(R.drawable.manage);
                        menu.findItem(R.id.usersetting).setIcon(R.drawable.profile);
                        setFrag(1);
                        break;

                    case R.id.transport:
                        menuItem.setIcon(R.drawable.bus_click);
                        menu.findItem(R.id.schedule).setIcon(R.drawable.schedule);
                        menu.findItem(R.id.alarm).setIcon(R.drawable.manage);
                        menu.findItem(R.id.navigation).setIcon(R.drawable.taxi);
                        menu.findItem(R.id.usersetting).setIcon(R.drawable.profile);
                        setFrag(2);
                        break;

                    case R.id.navigation:
                        menuItem.setIcon(R.drawable.taxi_click);
                        menu.findItem(R.id.alarm).setIcon(R.drawable.manage);
                        menu.findItem(R.id.transport).setIcon(R.drawable.bus);
                        menu.findItem(R.id.schedule).setIcon(R.drawable.schedule);
                        menu.findItem(R.id.usersetting).setIcon(R.drawable.profile);
                        setFrag(3);
                        break;


                    case R.id.usersetting:
                        menuItem.setIcon(R.drawable.profile_click);
                        menu.findItem(R.id.schedule).setIcon(R.drawable.schedule);
                        menu.findItem(R.id.transport).setIcon(R.drawable.bus);
                        menu.findItem(R.id.navigation).setIcon(R.drawable.taxi);
                        menu.findItem(R.id.alarm).setIcon(R.drawable.manage);
                        setFrag(4);
                        break;

                }
                return true;
            }
        }); //드로어블 해결함

        Alarmss = new AlarmsListFragment();
        Navigationss = new navigationss();
        Scheduless = new scheduless();
        Transportss = new transportss();
        Usersettingss = new usersettingss();

        bottomNavigationView.setSelectedItemId(R.id.alarm); //첫 Fragment 화면 지정(알람화면으로 해둠)


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
                ft.replace(R.id.mainFrame, Scheduless);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.mainFrame, Transportss);
                ft.commit();
                break;

            case 3:
                ft.replace(R.id.mainFrame, Navigationss);
                ft.commit();
                break;

            case 4:
                ft.replace(R.id.mainFrame, Usersettingss);
                ft.commit();
                break;
        }
    }


  /*  @Override//자바파일이름 선언
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
    }*/

    //뒤로가기버튼 1회 터치 후 2초안에 추가 터치시 어플 종료
    long pressedtime = 0;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()>pressedtime+2000){
            pressedtime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(),"어플을 종료합니다.",Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}



