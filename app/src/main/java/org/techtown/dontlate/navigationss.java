package org.techtown.dontlate;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


import org.techtown.dontlate.model.NaviAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class navigationss extends Fragment {

//머징 나 잠만 톡점 됐당 잘됨? 앱 중단떴어

    private View view;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    private String API_KEY = "KakaoAK 8ae57c6ab583cbe890979e12b4c0315a";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.navigations, container, false);

        MapView mapView = new MapView(getActivity());

        ViewGroup mapViewContainer = (ViewGroup) v.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

//        recyclerView = v.findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);

        callNaviItems();


        // 중심점 변경 - 예제 좌표는 서울 남산
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304), true);

        // 줌 레벨 변경
        mapView.setZoomLevel(4, true);

        //마커 찍기
        MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304);//
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("요기");
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.


        mapView.addPOIItem(marker);


        return v;
    }

    public void callNaviItems() {
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();
        retrofitInterface.AddressInfo(API_KEY, "127.10459896729914","37.40269721785548" ).enqueue(new Callback<NaviAPI>() {
            @Override
            public void onResponse(Call<NaviAPI> call, Response<NaviAPI> response) {
                NaviAPI naviAPI = response.body();
                Log.d("test", naviAPI.getNaviItem().get(0).getAddressName());
            }

            @Override
            public void onFailure(Call<NaviAPI> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }
}
