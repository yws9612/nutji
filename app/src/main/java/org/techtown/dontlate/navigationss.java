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


import org.techtown.dontlate.model.CategorySearch;
import org.techtown.dontlate.model.CoordRegionInfo;
import org.techtown.dontlate.model.KeywordSearch;
import org.techtown.dontlate.model.SearchingAddress;
import org.techtown.dontlate.model.TranslateAddress;
import org.techtown.dontlate.model.TranslateCoord;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class navigationss extends Fragment {


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


        callCoordRegionItems();
        callAddressItems();
        callTranslateAddressItems();
        callTranslateCoordItems();
        callKeywordSearchItems();
        callCategorySearchItems();


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

    public void callCoordRegionItems() {
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();
        retrofitInterface.RegionInfo(API_KEY, "127.10459896729914","37.40269721785548" ).enqueue(new Callback<CoordRegionInfo>() {
            @Override
            public void onResponse(Call<CoordRegionInfo> call, Response<CoordRegionInfo> response) {
                CoordRegionInfo coordRegionInfo = response.body();
                Log.d("test", coordRegionInfo.getCoordRegionInfoItems().get(0).getAddressName());
            }

            @Override
            public void onFailure(Call<CoordRegionInfo> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void callAddressItems() {
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();
        retrofitInterface.AddressInfo(API_KEY, "서울특별시 강동구 풍성로 128").enqueue(new Callback<SearchingAddress>() {
            @Override
            public void onResponse(Call<SearchingAddress> call, Response<SearchingAddress> response) {
                SearchingAddress searchingAddress = response.body();
                Log.d("testAddress", searchingAddress.getSearchingAddressItems().get(0).getAddressName());
            }

            @Override
            public void onFailure(Call<SearchingAddress> call, Throwable t) {
                Log.d("testAddress", t.toString());
            }
        });
    }

    public void callTranslateAddressItems() {
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();
        retrofitInterface.CoordInfo(API_KEY,"127.423084873712", "37.0789561558879").enqueue(new Callback<TranslateAddress>() {
            @Override
            public void onResponse(Call<TranslateAddress> call, Response<TranslateAddress> response) {
                TranslateAddress translateAddress = response.body();
                Log.d("testCoord", translateAddress.getTranslateAddressItems().get(0).getAddress().getAddressName());
            }

            @Override
            public void onFailure(Call<TranslateAddress> call, Throwable t) {
                Log.d("testCoord", t.toString());
            }
        });
    }

    public void callTranslateCoordItems() {
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();
        retrofitInterface.CoordxyInfo(API_KEY, 160710.37729270622, -4388.879299157299,"WTM", "WGS84").enqueue(new Callback<TranslateCoord>() {
            @Override
            public void onResponse(Call<TranslateCoord> call, Response<TranslateCoord> response) {
                TranslateCoord translateCoord = response.body();
                Log.d("testCoordxy", translateCoord.getTranslateCoordItems().get(0).getX().toString());
                Log.d("testCoordxy", translateCoord.getTranslateCoordItems().get(0).getY().toString());
            }

            @Override
            public void onFailure(Call<TranslateCoord> call, Throwable t) {
                Log.d("testCoordxy", t.toString());
            }
        });
    }

    public void callKeywordSearchItems() {
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();
        retrofitInterface.KeplaceInfo(API_KEY, "카카오프렌즈").enqueue(new Callback<KeywordSearch>() {
            @Override
            public void onResponse(Call<KeywordSearch> call, Response<KeywordSearch> response) {
                KeywordSearch keywordSearch = response.body();
                Log.d("testKplace", keywordSearch.getKeywordSearchItems().get(0).getAddressName());
            }

            @Override
            public void onFailure(Call<KeywordSearch> call, Throwable t) {
                Log.d("testKplace", t.toString());
            }
        });
    }

    public void callCategorySearchItems() {
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();
        retrofitInterface.CaplaceInfo(API_KEY, "PM9", 20000).enqueue(new Callback<CategorySearch>() {
            @Override
            public void onResponse(Call<CategorySearch> call, Response<CategorySearch> response) {
                CategorySearch categorySearch = response.body();
                Log.d("testCplace", categorySearch.getCategorySearchItems().get(0).getAddressName());
            }

            @Override
            public void onFailure(Call<CategorySearch> call, Throwable t) {
                Log.d("testCplace", t.toString());
            }
        });
    }

}
