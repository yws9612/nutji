package org.techtown.dontlate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

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

public class transportss extends Activity    {


    private NetworkThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transports);

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


    }
        //BusStationInfo(getActivity(), onSuccessListener);


//    public void BusStationInfo(Context context, PublicApi.OnSuccessListener onSuccessListener) {
//
//        // 싱글톤 생성, Key 값을 활용하여 객체 생성
//        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
//        // 서버 연결 제한 시간(단위(초), default : 5초)
//        odsayService.setReadTimeout(5000);
//        // 데이터 획득 제한 시간(단위(초), default : 5초)
//        odsayService.setConnectionTimeout(5000);
//
//        // 콜백 함수 구현
//        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
//            // 호출 성공 시 실행
//            @Override
//            public void onSuccess(ODsayData odsayData, API api) {
//                try {
//                    // API Value 는 API 호출 메소드 명을 따라갑니다.
//                    if (api == API.BUS_STATION_INFO) {
//                        String stationName = odsayData.getJson().getJSONObject("result").getString("stationName");
//                        onSuccessListener.onRequestSuccess(stationName);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 호출 실패 시 실행
//            @Override
//            public void onError(int i, String s, API api) {
//                if (api == API.BUS_STATION_INFO) {
//                }
//            }
//        };
//        // API 호출
//        odsayService.requestBusStationInfo("107475", onResultCallbackListener);
//    }
}
