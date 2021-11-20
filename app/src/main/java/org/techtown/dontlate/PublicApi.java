package org.techtown.dontlate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.odsay.odsayandroidsdk.API;
import com.odsay.odsayandroidsdk.ODsayData;
import com.odsay.odsayandroidsdk.ODsayService;
import com.odsay.odsayandroidsdk.OnResultCallbackListener;

import org.json.JSONException;

public class PublicApi extends AppCompatActivity {

    public interface OnSuccessListener {
        void onRequestSuccess(String result);
    }

//
//    public void apiTest(Context context, OnSuccessListener onSuccessListener) {
//
//// 싱글톤 생성, Key 값을 활용하여 객체 생성
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
//                        Log.d("Station name : %s", stationName);
//                        onSuccessListener.onRequestSuccess(stationName);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
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
//
//    public void TransitStop(Context context, PublicApi.OnSuccessListener onSuccessListener) {
//
//
//        ODsayService oDsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
//        oDsayService.setReadTimeout(5000);
//        oDsayService.setConnectionTimeout(5000);
//
//        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
//            @Override
//            public void onSuccess(ODsayData oDsayData, API api) {
//                try {
//                    if (api == API.SEARCH_STATION) {
//                        String ars_ID = oDsayData.getJson().getJSONObject("result").getJSONObject("station").getString("arsID");
//                        onSuccessListener.onRequestSuccess(ars_ID);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onError(int i, String s, API api) {
//                if (api == API.SEARCH_STATION) {
//                }
//            }
//        };
//        oDsayService.requestSearchStation("14","1000","1:2","10","1",
//                "127.0363583:37.5113295", onResultCallbackListener);
//    }

//      public void transTest(Context context, OnSuccessListener onSuccessListener) {
//
//          Intent intent = new Intent(getActivity().getApplicationContext(), transportss.class);
//
//          SX = intent.getDoubleExtra("sx",0);
//          SY = intent.getDoubleExtra("sy",0);
//          EX = intent.getDoubleExtra("ex",0);
//          EY = intent.getDoubleExtra("ey",0);
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
//                    if (api == API.SEARCH_PUB_TRANS_PATH) {
//                        String icResult = odsayData.getJson().getJSONObject("result").getString("startRadius");
//                        Log.d("icResult : %s", icResult);
//                        onSuccessListener.onRequestSuccess(icResult);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            // 호출 실패 시 실행
//            @Override
//            public void onError(int i, String s, API api) {
//                if (api == API.SEARCH_PUB_TRANS_PATH) {
//                }
//            }
//        };
//        // API 호출
//        odsayService.requestSearchPubTransPath(String.valueOf(SX),String.valueOf(SY),String.valueOf(EX),String.valueOf(EY),"0","0","0",onResultCallbackListener);
//    }

}
