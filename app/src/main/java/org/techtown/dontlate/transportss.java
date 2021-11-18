package org.techtown.dontlate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.odsay.odsayandroidsdk.API;
import com.odsay.odsayandroidsdk.ODsayData;
import com.odsay.odsayandroidsdk.ODsayService;
import com.odsay.odsayandroidsdk.OnResultCallbackListener;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;
import com.skt.Tmap.poi_item.TMapPOIItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.techtown.dontlate.model.NetworkThreadArsId;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class transportss extends Activity {

    Button fnBtn, sOkBtn;
    EditText editText;
    TextView textView, textView1,ttview;
    private NetworkThread thread;
    private NetworkThreadArsId threadArsId;
    private String queryUrl;
    private FirebaseDatabase database;
    ArrayList<Item> list = null;
    ArrayList<String> stCode = new ArrayList<>();
    Item bus = null;
    String data;
    String test;
    RecyclerView recyclerView;
    String startPoint, arrivePoint;
    public double stplo, stpla, arplo, arpla;
    public String SX,SY,EX,EY;
    String globalStartName, globalEndName;



    //seoulCitySubway.json 자체


    //??

    private String getJsonString()
    {
        String json = "";

        try {
            InputStream is = getAssets().open("seoulCitySubway.json");

            int fileSize = is.available();

            byte [] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();


            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i<jsonArray.length(); i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);

                if(obj.getString("station_nm").equals(startPoint))
                {
                    stCode.add(obj.getString("fr_code"));
                }

                if(obj.getString("station_nm").equals(arrivePoint))
                {
                    stCode.add(obj.getString("fr_code"));
                }
            }
            Log.d("testas", stCode.toString());
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return json;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transports);

        getJsonString();


        PublicApi.OnSuccessListener onSuccessListener = new PublicApi.OnSuccessListener() {
            @Override
            public void onRequestSuccess(String result) {

            }
        };


        fnBtn = (Button) findViewById(R.id.finish_Button);
        sOkBtn = (Button) findViewById(R.id.search_Ok_Button);
        ttview = (TextView) findViewById(R.id.testTextView);
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



        database.getReference("Nutji").child("User").child("Place").child("집").child("Address").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String value = snapshot.getValue(String.class);
                    startPoint = value;
                    ttview.setText(startPoint);
                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference("Nutji").child("User").child("Place").child("학교").child("Address").addValueEventListener(new ValueEventListener() {
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
                  geocoder.getFromLocationName("강동구청역",1);
          stpla = mResultLocation.get(0).getLatitude();
          stplo = mResultLocation.get(0).getLongitude();
          SX = String.valueOf(stplo);
          SY = String.valueOf(stpla);
      }catch (IOException e){
          e.printStackTrace();
      }

      Geocoder mGeocoder = new Geocoder(this);
      try{
          List<Address> mResultLocations =
                  mGeocoder.getFromLocationName("건대입구역",1);
          arpla = mResultLocations.get(0).getLatitude();
          arplo = mResultLocations.get(0).getLongitude();
          EX = String.valueOf(arplo);
          EY = String.valueOf(arpla);
      }catch (IOException e){
            e.printStackTrace();
      }

//        sOkBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AssetManager assetManager = getAssets();
//
//                try{
//                    InputStream is = assetManager.open("seoulCitySubway.json");
//                    InputStreamReader isr = new InputStreamReader(is);
//                    BufferedReader reader = new BufferedReader(isr);
//
//                    StringBuffer buffer = new StringBuffer();
//                    String line = reader.readLine();
//                    while (line!=null){
//                        buffer.append(line+"\n");
//                        line = reader.readLine();
//                    }
//
//                    String jsonData = buffer.toString();
//
//                    JSONArray jsonArray = new JSONArray(jsonData);
//
//                    String s ="";
//                    for(int i = 0; i<jsonArray.length(); i++){
//                        JSONObject jo = jsonArray.getJSONObject(i);
//
//                        String station = jo.getString("station_nm");
//                        String fCode = jo.getString("fr_code");
//
//                        s += station + ":" + fCode;
//                    }
//                    ttview.setText(s);
//                }catch (IOException e){
//                    e.printStackTrace();
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//            }
//        });
        Context context = this;



        // 싱글톤 생성, Key 값을 활용하여 객체 생성
        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        // 서버 연결 제한 시간(단위(초), default : 5초)
        odsayService.setReadTimeout(5000);
        // 데이터 획득 제한 시간(단위(초), default : 5초)
        odsayService.setConnectionTimeout(5000);

        // 콜백 함수 구현
        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            // 호출 성공 시 실행
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {

                    // API 호출구문
                    if (api == API.SEARCH_PUB_TRANS_PATH) {
                        //최초 출발역/정류장

                        String fssResult = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONObject("info").getString("firstStartStation");
                        String fssResult1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONObject("info").getString("firstStartStation");
                        String fssResult2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONObject("info").getString("firstStartStation");
                        String fssResult3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONObject("info").getString("firstStartStation");
                        String fssResult4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONObject("info").getString("firstStartStation");
                        String fssResult5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONObject("info").getString("firstStartStation");

                        //최종 도착역/정류장
                        String lesResult = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONObject("info").getString("lastEndStation");
                        String lesResult1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONObject("info").getString("lastEndStation");
                        String lesResult2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONObject("info").getString("lastEndStation");
                        String lesResult3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONObject("info").getString("lastEndStation");
                        String lesResult4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONObject("info").getString("lastEndStation");
                        String lesResult5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONObject("info").getString("lastEndStation");

                        //버스 번호
                        String bsName = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONArray("subPath").getJSONObject(1).getJSONArray("lane").getJSONObject(0).getString("busNo");
                        String bsName1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONArray("subPath").getJSONObject(1).getJSONArray("lane").getJSONObject(0).getString("busNo");
                        String bsName2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONArray("subPath").getJSONObject(1).getJSONArray("lane").getJSONObject(0).getString("busNo");
                        String bsName3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONArray("subPath").getJSONObject(1).getJSONArray("lane").getJSONObject(0).getString("busNo");
                        String bsName4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONArray("subPath").getJSONObject(1).getJSONArray("lane").getJSONObject(0).getString("busNo");
                        String bsName5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(6).getJSONArray("subPath").getJSONObject(1).getJSONArray("lane").getJSONObject(0).getString("busNo");

                        //지하철 노선명
                        String swyName = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(1).getJSONArray("lane").getJSONObject(0).getString("name");
                        String swyName1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(3).getJSONArray("lane").getJSONObject(0).getString("name");
                        String swyName2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(5).getJSONArray("lane").getJSONObject(0).getString("name");
                        //총 거리
                        String ttDis = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONObject("info").getString("totalDistance");
                        String ttDis1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONObject("info").getString("totalDistance");
                        String ttDis2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONObject("info").getString("totalDistance");
                        String ttDis3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONObject("info").getString("totalDistance");
                        String ttDis4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONObject("info").getString("totalDistance");
                        String ttDis5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONObject("info").getString("totalDistance");

                        //총 요금
                        String payment = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONObject("info").getString("payment");
                        String payment1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONObject("info").getString("payment");
                        String payment2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONObject("info").getString("payment");
                        String payment3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONObject("info").getString("payment");
                        String payment4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONObject("info").getString("payment");
                        String payment5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONObject("info").getString("payment");

                        //총 도보 이동거리
                        String ttWalk = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONObject("info").getString("totalWalk");
                        String ttWalk1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONObject("info").getString("totalWalk");
                        String ttWalk2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONObject("info").getString("totalWalk");
                        String ttWalk3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONObject("info").getString("totalWalk");
                        String ttWalk4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONObject("info").getString("totalWalk");
                        String ttWalk5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONObject("info").getString("totalWalk");

                        //총 소요 시간
                        String ttTime = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONObject("info").getString("totalTime");
                        String ttTime1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONObject("info").getString("totalTime");
                        String ttTime2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONObject("info").getString("totalTime");
                        String ttTime3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONObject("info").getString("totalTime");
                        String ttTime4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONObject("info").getString("totalTime");
                        String ttTime5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONObject("info").getString("totalTime");

                        //승차 정류장/역명
                        String staName = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(1).getString("startName");
                        String staName1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONArray("subPath").getJSONObject(1).getString("startName");
                        String staName2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONArray("subPath").getJSONObject(1).getString("startName");
                        String staName3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONArray("subPath").getJSONObject(1).getString("startName");
                        String staName4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONArray("subPath").getJSONObject(1).getString("startName");
                        String staName5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONArray("subPath").getJSONObject(1).getString("startName");

                        //하차 정류장/역명
                        String edName = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(1).getString("endName");
                        String edName1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(1).getJSONArray("subPath").getJSONObject(1).getString("endName");
                        String edName2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(2).getJSONArray("subPath").getJSONObject(1).getString("endName");
                        String edName3 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(3).getJSONArray("subPath").getJSONObject(1).getString("endName");
                        String edName4 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(4).getJSONArray("subPath").getJSONObject(1).getString("endName");
                        String edName5 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(5).getJSONArray("subPath").getJSONObject(1).getString("endName");

                        //방면 정보
                        String dirWay = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(1).getString("way");
                        String dirWay1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(3).getString("way");
                        String dirWay2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(5).getString("way");

                        //지하철 빠른 환승 위치
                        String trDoor = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(1).getString("door");
                        String trDoor1 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(3).getString("door");
                        String trDoor2 = odsayData.getJson().getJSONObject("result").getJSONArray("path").getJSONObject(0).getJSONArray("subPath").getJSONObject(5).getString("door");

                        //지하철 들어가는 출구 번호


                        //출발역 호출
                        onSuccessListener.onRequestSuccess(fssResult);
                        onSuccessListener.onRequestSuccess(fssResult1);
                        onSuccessListener.onRequestSuccess(fssResult2);
                        onSuccessListener.onRequestSuccess(fssResult3);
                        onSuccessListener.onRequestSuccess(fssResult4);
                        onSuccessListener.onRequestSuccess(fssResult5);

                        //도착역 호출
                        onSuccessListener.onRequestSuccess(lesResult);
                        onSuccessListener.onRequestSuccess(lesResult1);
                        onSuccessListener.onRequestSuccess(lesResult2);
                        onSuccessListener.onRequestSuccess(lesResult3);
                        onSuccessListener.onRequestSuccess(lesResult4);
                        onSuccessListener.onRequestSuccess(lesResult5);

                        //버스 번호 조회
                        onSuccessListener.onRequestSuccess(bsName);
                        onSuccessListener.onRequestSuccess(bsName1);
                        onSuccessListener.onRequestSuccess(bsName2);
                        onSuccessListener.onRequestSuccess(bsName3);
                        onSuccessListener.onRequestSuccess(bsName4);
                        onSuccessListener.onRequestSuccess(bsName5);

                        //지하철 노선명 조회
                        onSuccessListener.onRequestSuccess(swyName);
                        onSuccessListener.onRequestSuccess(swyName1);
                        onSuccessListener.onRequestSuccess(swyName2);

                        //총 거리 조회
                        onSuccessListener.onRequestSuccess(ttDis);
                        onSuccessListener.onRequestSuccess(ttDis1);
                        onSuccessListener.onRequestSuccess(ttDis2);
                        onSuccessListener.onRequestSuccess(ttDis3);
                        onSuccessListener.onRequestSuccess(ttDis4);
                        onSuccessListener.onRequestSuccess(ttDis5);

                        //총 요금 조회
                        onSuccessListener.onRequestSuccess(payment);
                        onSuccessListener.onRequestSuccess(payment1);
                        onSuccessListener.onRequestSuccess(payment2);
                        onSuccessListener.onRequestSuccess(payment3);
                        onSuccessListener.onRequestSuccess(payment4);
                        onSuccessListener.onRequestSuccess(payment5);

                        //총 도보 이동거리 조회
                        onSuccessListener.onRequestSuccess(ttWalk);
                        onSuccessListener.onRequestSuccess(ttWalk1);
                        onSuccessListener.onRequestSuccess(ttWalk2);
                        onSuccessListener.onRequestSuccess(ttWalk3);
                        onSuccessListener.onRequestSuccess(ttWalk4);
                        onSuccessListener.onRequestSuccess(ttWalk5);

                        //총 소요 시간 조회
                        onSuccessListener.onRequestSuccess(ttTime);
                        onSuccessListener.onRequestSuccess(ttTime1);
                        onSuccessListener.onRequestSuccess(ttTime2);
                        onSuccessListener.onRequestSuccess(ttTime3);
                        onSuccessListener.onRequestSuccess(ttTime4);
                        onSuccessListener.onRequestSuccess(ttTime5);

                        //승차 정류장/역명 호출
                        onSuccessListener.onRequestSuccess(staName);
                        onSuccessListener.onRequestSuccess(staName1);
                        onSuccessListener.onRequestSuccess(staName2);
                        onSuccessListener.onRequestSuccess(staName3);
                        onSuccessListener.onRequestSuccess(staName4);
                        onSuccessListener.onRequestSuccess(staName5);

                        //하차 정류장/역명 호출
                        onSuccessListener.onRequestSuccess(edName);
                        onSuccessListener.onRequestSuccess(edName1);
                        onSuccessListener.onRequestSuccess(edName2);
                        onSuccessListener.onRequestSuccess(edName3);
                        onSuccessListener.onRequestSuccess(edName4);
                        onSuccessListener.onRequestSuccess(edName5);

                        //방면 정보 호출
                        onSuccessListener.onRequestSuccess(dirWay);
                        onSuccessListener.onRequestSuccess(dirWay1);
                        onSuccessListener.onRequestSuccess(dirWay2);

                        //지하철 빠른 환승 위치
                        onSuccessListener.onRequestSuccess(trDoor);
                        onSuccessListener.onRequestSuccess(trDoor1);
                        onSuccessListener.onRequestSuccess(trDoor2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            // 호출 실패 시 실행
            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SEARCH_PUB_TRANS_PATH) {
                }
            }
        };
        // A PI 호출
        odsayService.requestSearchPubTransPath(SX,SY,EX,EY,"1","0","0",onResultCallbackListener);

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
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            TransAdapter adapter = new TransAdapter(getApplicationContext(), list);
            recyclerView.setAdapter(adapter);
        }


    }
}


