package org.techtown.dontlate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.odsay.odsayandroidsdk.API;
import com.odsay.odsayandroidsdk.ODsayData;
import com.odsay.odsayandroidsdk.ODsayService;
import com.odsay.odsayandroidsdk.OnResultCallbackListener;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;
import com.skt.Tmap.poi_item.TMapPOIItem;

import org.json.JSONException;
import org.techtown.dontlate.model.NetworkThreadArsId;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class transportss extends Activity {

    Button fnBtn, sOkBtn;
    EditText editText;
    TextView textView, textView1;
    private NetworkThread thread;
    private NetworkThreadArsId threadArsId;
    private String queryUrl;
    private FirebaseDatabase database;
    ArrayList<Item> list = null;
    Item bus = null;
    String data;
    String test;
    RecyclerView recyclerView;
    String startPoint, arrivePoint;
    double stplo, stpla, arplo, arpla;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transports);

        fnBtn = (Button) findViewById(R.id.finish_Button);
        sOkBtn = (Button) findViewById(R.id.search_Ok_Button);
        recyclerView = (RecyclerView) findViewById(R.id.transRecycler);
        recyclerView.setHasFixedSize(true);



        database = FirebaseDatabase.getInstance();



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        TransAsyncTask transAsyncTask = new TransAsyncTask();
        transAsyncTask.execute();



        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpecRecommand = tabHost.newTabSpec("recommand").setIndicator("추천 경로");
        tabSpecRecommand.setContent(R.id.recommand);
        tabHost.addTab(tabSpecRecommand);

        TabHost.TabSpec tabSpecBusroad = tabHost.newTabSpec("busroad").setIndicator("버스");
        tabSpecBusroad.setContent(R.id.busRoad);
        tabHost.addTab(tabSpecBusroad);

        TabHost.TabSpec tabSpecSubway = tabHost.newTabSpec("subway").setIndicator("지하철");
        tabSpecSubway.setContent(R.id.subwayRoad);
        tabHost.addTab(tabSpecSubway);

        TabHost.TabSpec tabSpecMinimize = tabHost.newTabSpec("minimizewalk").setIndicator("최소 도보");
        tabSpecMinimize.setContent(R.id.minimizeWalk);
        tabHost.addTab(tabSpecMinimize);

        tabHost.setCurrentTab(0);


        fnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        database.getReference().child("nutji").child("User").child("Place").child("1").child("PlaceName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                startPoint = value;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child("nutji").child("User").child("Place").child("2").child("PlaceName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                arrivePoint = value;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


      Geocoder geocoder = new Geocoder(this);
      try{
          List<Address> mResultLocation =
                  geocoder.getFromLocationName(startPoint,1);
          stpla = mResultLocation.get(0).getLatitude();
          stplo = mResultLocation.get(0).getLongitude();
      }catch (IOException e){
          e.printStackTrace();
      }

      Geocoder mGeocoder = new Geocoder(this);
      try{
          List<Address> mResultLocations =
                  mGeocoder.getFromLocationName(arrivePoint,1);
          arpla = mResultLocations.get(0).getLatitude();
          arplo = mResultLocations.get(0).getLongitude();
      }catch (IOException e){
            e.printStackTrace();
      }





    }

    public class TransAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            queryUrl = "http://ws.bus.go.kr/api/rest/stationinfo/getLowStationByUid?"
                    + "ServiceKey=de8Q96jmb%2FJj%2BopbZdsPv5k4%2F2XDiyfTluNAwrhznOJROomUFPdf7D4M%2Bzw%2BbXjCIY%2B1VqXP%2BTmJaY7wOShFIA%3D%3D&arsId=48066";

            try {
                boolean b_stnNm = false;
                boolean b_rtNm = false;
                boolean b_stationNm1 = false;
                boolean b_arrmsg1 = false;

                URL url = new URL(queryUrl);
                InputStream is = url.openStream();
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new InputStreamReader(is, "UTF-8"));

                String tag;
                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            list = new ArrayList<Item>();
                            break;

                        case XmlPullParser.END_DOCUMENT:
                            break;

                        case XmlPullParser.END_TAG:
                            if (xpp.getName().equals("itemList") && bus != null) {
                                list.add(bus);
                            }
                            break;

                        case XmlPullParser.START_TAG:
                            if (xpp.getName().equals("itemList")) {
                                bus = new Item();
                            }
                            if (xpp.getName().equals("stnNm"))
                                b_stnNm = true;

                            if (xpp.getName().equals("rtNm"))
                                b_rtNm = true;

                            if (xpp.getName().equals("stationNm1"))
                                b_stationNm1 = true;

                            if (xpp.getName().equals("arrmsg1"))
                                b_arrmsg1 = true;
                            break;

                        case XmlPullParser.TEXT:
                            if (b_stnNm) {
                                bus.setStnNm(xpp.getText());
                                b_stnNm = false;
                            } else if (b_rtNm) {
                                bus.setRtNm(xpp.getText());
                                b_rtNm = false;
                            } else if (b_stationNm1) {
                                bus.setStationNm1(xpp.getText());
                                b_stationNm1 = false;
                            } else if (b_arrmsg1) {
                                bus.setArrmsg1(xpp.getText());
                                b_arrmsg1 = false;
                            }
                            break;
                    }
                    eventType = xpp.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected  void onPostExecute(String s) {
            super.onPostExecute(s);


            TransAdapter adapter = new TransAdapter(getApplicationContext(), list);
            recyclerView.setAdapter(adapter);
        }
        //버튼 클릭시 쓰레드를 생성하여 해당 함수를 실행후 텍스트뷰에 데이터 출력
//    public void buttonClicked(View v){
//        switch (v.getId()){
//            case R.id.search_Ok_Button:
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        data = getData();
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setText(data);
//                            }
//                        });
//                    }
//                }).start();
//                break;
//        }
//    }


//    String getData() {
//        StringBuffer buffer = new StringBuffer();
//
//        String str = editText.getText().toString();
//        String location = URLEncoder.encode(str);
//
//        String queryUrl="http://ws.bus.go.kr/api/rest/stationinfo/getLowStationByUid?"
//                + "ServiceKey=de8Q96jmb%2FJj%2BopbZdsPv5k4%2F2XDiyfTluNAwrhznOJROomUFPdf7D4M%2Bzw%2BbXjCIY%2B1VqXP%2BTmJaY7wOShFIA%3D%3D&arsId="+location;
//
//        try{
//            URL url = new URL(queryUrl);
//            InputStream is = url.openStream();
//
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser xpp = factory.newPullParser();
//            xpp.setInput(new InputStreamReader(is, "UTF-8"));
//
//            String tag;
//
//
//            xpp.next();
//            int eventType = xpp.getEventType();
//
//            while(eventType != XmlPullParser.END_DOCUMENT){
//                switch (eventType){
//                    case XmlPullParser.START_DOCUMENT:
//                        buffer.append("파싱 시작 단계\n\n");
//                        break;
//
//
//
//                    case XmlPullParser.START_TAG:
//                        tag = xpp.getName();
//
//                        if (tag.equals("item"));
//                        else if(tag.equals("stnNm")){
//                            buffer.append("정류소 이름 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("rtNm")){
//                            buffer.append("노선 이름 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("firstTm")){
//                            buffer.append("첫 차 시간 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("lastTm")){
//                            buffer.append("막차 시간 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("term")){
//                            buffer.append("배차 간격 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("routeType")){
//                            buffer.append("노선 유형 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("nextBus")){
//                            buffer.append("막차 운행 여부 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("staOrd")){
//                            buffer.append("요청 정류소 순번 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("vehId1")){
//                            buffer.append("첫번째 도착 예정 버스 ID : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("vehId2")){
//                            buffer.append("두번째 도착 예정 버스 ID : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("plainNo1")){
//                            buffer.append("첫번째 도착 예정 차량 번호 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("plainNo2")){
//                            buffer.append("두번째 도착 예정 차량 번호 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("sectOrd1")){
//                            buffer.append("첫번째 도착 예정 버스의 현재 구간 순번 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("sectOrd2")){
//                            buffer.append("두번째 도착 예정 버스의 현재 구간 순번 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("stationNm1")){
//                            buffer.append("첫번째 도착 예정버스의 최종 정류소명 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("stationNm2")){
//                            buffer.append("두번째 도착 예정버스의 최종 정류소명 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("isArrive1")){
//                            buffer.append("첫번째 도착 예정버스의 최종 정류소 도착 출발 여부 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("isArrive2")){
//                            buffer.append("두번째 도착 예정버스의 최종 정류소 도착 출발 여부 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("busType1")){
//                            buffer.append("첫번째 도착 예정버스의 차량 유형 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("busType2")){
//                            buffer.append("두번째 도착 예정버스의 차량 유형 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("repTm1")){
//                            buffer.append("첫번째 도착 예정 버스의 최종 보고시간 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("repTm2")){
//                            buffer.append("en번째 도착 예정 버스의 최종 보고시간 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("arrmsg1")){
//                            buffer.append("첫번째 도착 예정버스의 도착정보 메시지 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("arrmsg2")){
//                            buffer.append("두번째 도착 예정버스의 도착정보 메시지 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("sectNm")){
//                            buffer.append("구간명 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        else if(tag.equals("deTourAt")){
//                            buffer.append("우회 여부 : ");
//                            xpp.next();
//
//                            buffer.append(xpp.getText());
//                            buffer.append("\n");
//                        }
//                        break;
//
//                    case XmlPullParser.TEXT:
//                        break;
//
//                    case XmlPullParser.END_TAG:
//                        tag=xpp.getName();
//                        if(tag.equals("item")) buffer.append("\n");
//                        break;
//                }
//                eventType=xpp.next();
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        buffer.append("파싱 종료 단계 \n");
//        return buffer.toString();
//    }
    }
}


