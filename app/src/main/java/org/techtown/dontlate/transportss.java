package org.techtown.dontlate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import com.google.android.material.tabs.TabLayout;
import com.odsay.odsayandroidsdk.API;
import com.odsay.odsayandroidsdk.ODsayData;
import com.odsay.odsayandroidsdk.ODsayService;
import com.odsay.odsayandroidsdk.OnResultCallbackListener;
import com.skt.Tmap.TMapView;

import org.json.JSONException;
import org.techtown.dontlate.model.NetworkThreadArsId;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class transportss extends Activity {


    Button fnBtn, sOkBtn;
    EditText editText;
    TextView textView;
    private NetworkThread thread;
    private NetworkThreadArsId threadArsId;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transports);

        fnBtn = (Button) findViewById(R.id.finish_Button);
        sOkBtn = (Button) findViewById(R.id.search_Ok_Button);
        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.editText);


        thread = new NetworkThread();
        thread.start();



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



        LinearLayout linearLayoutTmaps = (LinearLayout) findViewById(R.id.linearLayoutTmaps);
        TMapView tMapViews= new TMapView(this);

        tMapViews.setSKTMapApiKey("l7xxddf8547d834c4053946c4a168738d92f");
        linearLayoutTmaps.addView(tMapViews);


        LinearLayout linearLayoutTmapss= (LinearLayout) findViewById(R.id.linearLayoutTmapss);
        TMapView tMapViewss = new TMapView(this);

        tMapViewss.setSKTMapApiKey("l7xxddf8547d834c4053946c4a168738d92f");
        linearLayoutTmapss.addView(tMapViewss);

        fnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
    //버튼 클릭시 쓰레드를 생성하여 해당 함수를 실행후 텍스트뷰에 데이터 출력
    public void buttonClicked(View v){
        switch (v.getId()){
            case R.id.search_Ok_Button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data = getData();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(data);
                            }
                        });
                    }
                }).start();
                break;
        }
    }

    String getData() {
        StringBuffer buffer = new StringBuffer();

        String str = editText.getText().toString();
        String location = URLEncoder.encode(str);

        String queryUrl="http://ws.bus.go.kr/api/rest/stationinfo/getLowStationByUid?"
                + "ServiceKey=de8Q96jmb%2FJj%2BopbZdsPv5k4%2F2XDiyfTluNAwrhznOJROomUFPdf7D4M%2Bzw%2BbXjCIY%2B1VqXP%2BTmJaY7wOShFIA%3D%3D&arsId="+location;

        try{
            URL url = new URL(queryUrl);
            InputStream is = url.openStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작 단계\n\n");
                        break;



                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();

                        if (tag.equals("item"));
                        else if(tag.equals("stnNm")){
                            buffer.append("정류소 이름 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("rtNm")){
                            buffer.append("노선 이름 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("firstTm")){
                            buffer.append("첫 차 시간 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("lastTm")){
                            buffer.append("막차 시간 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("term")){
                            buffer.append("배차 간격 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("routeType")){
                            buffer.append("노선 유형 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("nextBus")){
                            buffer.append("막차 운행 여부 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("staOrd")){
                            buffer.append("요청 정류소 순번 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("vehId1")){
                            buffer.append("첫번째 도착 예정 버스 ID : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("vehId2")){
                            buffer.append("두번째 도착 예정 버스 ID : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("plainNo1")){
                            buffer.append("첫번째 도착 예정 차량 번호 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("plainNo2")){
                            buffer.append("두번째 도착 예정 차량 번호 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("sectOrd1")){
                            buffer.append("첫번째 도착 예정 버스의 현재 구간 순번 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("sectOrd2")){
                            buffer.append("두번째 도착 예정 버스의 현재 구간 순번 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("stationNm1")){
                            buffer.append("첫번째 도착 예정버스의 최종 정류소명 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("stationNm2")){
                            buffer.append("두번째 도착 예정버스의 최종 정류소명 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("isArrive1")){
                            buffer.append("첫번째 도착 예정버스의 최종 정류소 도착 출발 여부 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("isArrive2")){
                            buffer.append("두번째 도착 예정버스의 최종 정류소 도착 출발 여부 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("busType1")){
                            buffer.append("첫번째 도착 예정버스의 차량 유형 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("busType2")){
                            buffer.append("두번째 도착 예정버스의 차량 유형 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("repTm1")){
                            buffer.append("첫번째 도착 예정 버스의 최종 보고시간 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("repTm2")){
                            buffer.append("en번째 도착 예정 버스의 최종 보고시간 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("arrmsg1")){
                            buffer.append("첫번째 도착 예정버스의 도착정보 메시지 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("arrmsg2")){
                            buffer.append("두번째 도착 예정버스의 도착정보 메시지 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("sectNm")){
                            buffer.append("구간명 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("deTourAt")){
                            buffer.append("우회 여부 : ");
                            xpp.next();

                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag=xpp.getName();
                        if(tag.equals("item")) buffer.append("\n");
                        break;
                }
                eventType=xpp.next();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        buffer.append("파싱 종료 단계 \n");
        return buffer.toString();
    }

}


