package org.techtown.dontlate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import org.techtown.dontlate.model.PoiDetailSearch;
import org.techtown.dontlate.model.PoiSearch;
import org.techtown.dontlate.model.SearchPoiInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class navigationss extends Fragment {


    private View view;



    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.navigations, container, false);




        LinearLayout linearLayoutTmap = (LinearLayout) v.findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(getActivity());

        tMapView.setSKTMapApiKey("l7xxddf8547d834c4053946c4a168738d92f");
        linearLayoutTmap.addView(tMapView);





        callSearchPoiInfo();
        callSearchDetailInfo();

//        TMapMarkerItem markerItem1 = new TMapMarkerItem();
//
//        TMapPoint tMapPoint1 = new TMapPoint(37.570841, 126.985302); // SKT타워
//
// //마커 아이콘
//        Bitmap bitmap = BitmapFactory.decodeResource(mFcontext.getResources(), R.drawable.pin_r_m_a);
//
//        markerItem1.setIcon(bitmap); // 마커 아이콘 지정
//        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
//        markerItem1.setTMapPoint( tMapPoint1 ); // 마커의 좌표 지정
//        markerItem1.setName("SKT타워"); // 마커의 타이틀 지정
//        tMapView.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가
//
//        tMapView.setCenterPoint( 126.985302, 37.570841 ); //정상 작동 확인 완료







        return v;
    }

    public void callSearchPoiInfo() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<String, String> data = new HashMap<>();
        data.put("version", String.valueOf(1));
        data.put("searchKeyword", "빈스빈스 마포 공덕점" );
        data.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");

        retrofitInterface.getSearch(data).enqueue(new Callback<PoiSearch>() {
            @Override
            public void onResponse(Call<PoiSearch> call, Response<PoiSearch> response) {
                PoiSearch poiSearch = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(poiSearch.getSearchPoiInfo().getPois().getPoi().get(0).getName()));
            }

            @Override
            public void onFailure(Call<PoiSearch> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });

    }

    public void callSearchDetailInfo() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();


        HashMap<String, String> dedata = new HashMap<>();
        dedata.put("version", String.valueOf(1));
        dedata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
        dedata.put("resCoordType", "WGS84GEO");
        dedata.put("callback", "function");


        retrofitInterface.getDetailSearch("4670161",dedata).enqueue(new Callback<PoiDetailSearch>() {
            @Override
            public void onResponse(Call<PoiDetailSearch> call, Response<PoiDetailSearch> response) {
                PoiDetailSearch poiDetailSearch = response.body();
                Log.d("testde", poiDetailSearch.getPoiDetailInfo().getAddress());
            }

            @Override
            public void onFailure(Call<PoiDetailSearch> call, Throwable t) {
                Log.d("testde", t.toString());

            }
        });
    }
}
