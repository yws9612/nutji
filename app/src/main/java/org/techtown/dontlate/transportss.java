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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.InternalTokenProvider;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.http.Url;

public class transportss extends Activity {

    Button fnBtn, sOkBtn;
    TextView ttview;
    private NetworkThread thread;
    private NetworkThreadArsId threadArsId;
    String queryUrl;
    private FirebaseDatabase database;
    ArrayList<Item> list = null;
    ArrayList<String> stCode = new ArrayList<>();
    ArrayList<String> etCode = new ArrayList<>();
    Item bus = null;
    RecyclerView recyclerView;
    RecyclerView srecyclerView;
    String startPoint, arrivePoint;
    public double stplo, stpla, arplo, arpla;
    public String SX, SY, EX, EY;
    String ssId, esId, globalStartName, globalEndName;
    String glsName, gleName, gltTime, glsCount, adFare, laName, selaName, thlaName, sttName, sesttName, thsttName, stCount, sestCount, thstCount, waName, sewaName, thwaName;
    TextView gtTimes, glsNames, gleNames, glsCounts, adFares, lnNames, sttNames, sttCounts, waNames, selnNames, thlnNames, sesttNames, thsttNames, sesttCounts, thsttCounts, sewaNames, thwaNames;
    String ars1,ars2,ars3,ars4,ars5,ars6,arsPoint;
    Spinner srpt, arpt;
    String qwer, qwerty;



    //seoulCitySubway.json 자체


    //??

    private String getJsonString() {
        String json = "";

        try {
            InputStream is = getAssets().open("seoulCitySubway.json");

            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();


            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            globalStartName = "강동구청";

            globalEndName = "정발산";

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.getString("station_nm").equals(globalStartName)) {
                    stCode.add(obj.getString("fr_code"));
                }

                if (obj.getString("station_nm").equals(globalEndName)) {
                    etCode.add(obj.getString("fr_code"));
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transports);

        gtTimes = findViewById(R.id.tv_gtTimess);
        glsNames = findViewById(R.id.tv_glsNamess);
        gleNames = findViewById(R.id.tv_gleNamess);
        glsCounts = findViewById(R.id.tv_glsCountss);
        adFares= findViewById(R.id.tv_adFaress);

        lnNames = findViewById(R.id.tv_lnNamess);
        selnNames = findViewById(R.id.tv_selnNamess);
        thlnNames = findViewById(R.id.tv_thlnNamess);

        sttNames = findViewById(R.id.tv_sttNamess);
        sesttNames = findViewById(R.id.tv_sesttNamess);
        thsttNames = findViewById(R.id.tv_thsttNamess);

        sttCounts = findViewById(R.id.tv_sttCountss);
        sesttCounts = findViewById(R.id.tv_sesttCountss);
        thsttCounts = findViewById(R.id.tv_thsttCountss);

        waNames = findViewById(R.id.tv_waNamess);
        sewaNames = findViewById(R.id.tv_sewaNamess);
        thwaNames = findViewById(R.id.tv_thwaNamess);

        srpt = findViewById(R.id.startPoint);
        arpt = findViewById(R.id.arrivePoint);
        TextView test = findViewById(R.id.guideText);

        Context context = this;


        PublicApi.OnSuccessListener onSuccessListener = new PublicApi.OnSuccessListener() {
            @Override
            public void onRequestSuccess(String result) {

            }
        };


        getJsonString();


        ssId = stCode.get(0);
        esId = etCode.get(0);


        fnBtn = (Button) findViewById(R.id.finish_Button);
        sOkBtn = (Button) findViewById(R.id.search_Ok_Button);




        recyclerView = (RecyclerView) findViewById(R.id.transRecycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);







        database = FirebaseDatabase.getInstance();



        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpecBusroad = tabHost.newTabSpec("busroad").setIndicator("버스");
        tabSpecBusroad.setContent(R.id.busRoad);
        tabHost.addTab(tabSpecBusroad);

        TabHost.TabSpec tabSpecSubway = tabHost.newTabSpec("subway").setIndicator("지하철");
        tabSpecSubway.setContent(R.id.subwayRoad);
        tabHost.addTab(tabSpecSubway);


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
                //Log.d("test", arrivePoint);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //윤지네 집
        ars1 = "24186";

        //동서울대학교
        ars2 = "48066";

        //회사 (강남)
        ars3 = "22011";

        String[] items = {"선택", "집", "학교", "회사"};

        ArrayAdapter<String> Sadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        Sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        srpt.setAdapter(Sadapter);

        srpt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                qwer = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> Aadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        Aadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arpt.setAdapter(Aadapter);



        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> mResultLocation =
                    geocoder.getFromLocationName("강동구청역", 1);
            stpla = mResultLocation.get(0).getLatitude();
            stplo = mResultLocation.get(0).getLongitude();
            SX = String.valueOf(stplo);
            SY = String.valueOf(stpla);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Geocoder mGeocoder = new Geocoder(this);
        try {
            List<Address> mResultLocations =
                    mGeocoder.getFromLocationName("건대입구역", 1);
            arpla = mResultLocations.get(0).getLatitude();
            arplo = mResultLocations.get(0).getLongitude();
            EX = String.valueOf(arplo);
            EY = String.valueOf(arpla);
        } catch (IOException e) {
            e.printStackTrace();
        }


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
                    if (api == API.SUBWAY_PATH) {

                        //출발역 명
                        glsName = odsayData.getJson().getJSONObject("result").getString("globalStartName");
                        glsNames.setText(glsName);

                        //도착역 명
                        gleName = odsayData.getJson().getJSONObject("result").getString("globalEndName");
                        gleNames.setText(gleName);

                        //소요시간

                        gltTime = odsayData.getJson().getJSONObject("result").getString("globalTravelTime");
                        gtTimes.setText(gltTime);


                        //정차역 수
                        glsCount = odsayData.getJson().getJSONObject("result").getString("globalStationCount");
                        glsCounts.setText(glsCount);

                        //카드요금
                        adFare = odsayData.getJson().getJSONObject("result").getString("fare");
                        adFares.setText(adFare);


                        //승차역 호선명
                        laName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(0).getString("laneName");
                        lnNames.setText(laName);
                        try {
                            selaName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(1).getString("laneName");
                            selnNames.setText(selaName);

                            thlaName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(2).getString("laneName");
                            thlnNames.setText(thlaName);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            throw e;

                        } finally {
                            //승차역 명
                            sttName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(0).getString("startName");
                            sttNames.setText(sttName);
                            try {
                                sesttName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(1).getString("startName");
                                sesttNames.setText(sesttName);

                                thsttName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(2).getString("startName");
                                thsttNames.setText(thsttName);

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                                throw e;
                            } finally {
                                //이동역 수
                                stCount = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(0).getString("stationCount");
                                sttCounts.setText(stCount);
                                try {
                                    sestCount = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(1).getString("stationCount");
                                    sesttCounts.setText(sestCount);

                                    thstCount = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(2).getString("stationCount");
                                    thsttCounts.setText(thstCount);
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                    throw e;
                                } finally {
                                    //방면 명
                                    waName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(0).getString("wayName");
                                    waNames.setText(waName);
                                    try {
                                        sewaName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(1).getString("wayName");
                                        sewaNames.setText(sewaName);

                                        thwaName = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getJSONObject(2).getString("wayName");
                                        thwaNames.setText(thwaName);
                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                        throw e;
                                    } finally {
                                        //출발역 명 호출
                                        onSuccessListener.onRequestSuccess(glsName);

                                        //도착역 명 호출
                                        onSuccessListener.onRequestSuccess(gleName);

                                        //소요시간 호출
                                        onSuccessListener.onRequestSuccess(gltTime);

                                        //정차역 수
                                        onSuccessListener.onRequestSuccess(glsCount);

                                        //카드요금 호출
                                        onSuccessListener.onRequestSuccess(adFare);

                                        //승차역 호선명 호출
                                        onSuccessListener.onRequestSuccess(laName);
                                        onSuccessListener.onRequestSuccess(selaName);
                                        onSuccessListener.onRequestSuccess(thlaName);

                                        //승차역명 호출
                                        onSuccessListener.onRequestSuccess(sttName);
                                        onSuccessListener.onRequestSuccess(sesttName);
                                        onSuccessListener.onRequestSuccess(thsttName);

                                        //이동역수 호출
                                        onSuccessListener.onRequestSuccess(stCount);
                                        onSuccessListener.onRequestSuccess(sestCount);
                                        onSuccessListener.onRequestSuccess(thstCount);

                                        //방면명 호출
                                        onSuccessListener.onRequestSuccess(waName);
                                        onSuccessListener.onRequestSuccess(sewaName);
                                        onSuccessListener.onRequestSuccess(thwaName);
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            // 호출 실패 시 실행
            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SUBWAY_PATH) {
                }
            }
        };
        //API 호출
        odsayService.requestSubwayPath("1000", ssId, esId, "1", onResultCallbackListener);

        sOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (qwer) {
                    case "선택":
                        break;
                    case "집":
                        arsPoint = ars1;
                        break;
                    case "학교":
                        arsPoint = ars2;
                        break;
                    case "회사":
                        arsPoint = ars3;
                        break;
                }
                TransAsyncTask transAsyncTask = new TransAsyncTask();
                transAsyncTask.execute();
            }
        });


    }


    public class TransAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            queryUrl = "http://ws.bus.go.kr/api/rest/stationinfo/getLowStationByUid?"
                    + "ServiceKey=de8Q96jmb%2FJj%2BopbZdsPv5k4%2F2XDiyfTluNAwrhznOJROomUFPdf7D4M%2Bzw%2BbXjCIY%2B1VqXP%2BTmJaY7wOShFIA%3D%3D&arsId="+ arsPoint;


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



