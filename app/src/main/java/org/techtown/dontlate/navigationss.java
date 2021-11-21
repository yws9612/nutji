 package org.techtown.dontlate;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import org.techtown.dontlate.model.AreaSearching;
import org.techtown.dontlate.model.EupMyunDongSearch;
import org.techtown.dontlate.model.FullTextGeocoding;
import org.techtown.dontlate.model.Geocoding;
import org.techtown.dontlate.model.NearRoad;
import org.techtown.dontlate.model.PoiCategory;
import org.techtown.dontlate.model.PoiDetailSearch;
import org.techtown.dontlate.model.PoiSearch;
import org.techtown.dontlate.model.PostSearch;
import org.techtown.dontlate.model.RegionDivide;
import org.techtown.dontlate.model.RegionSearching;
import org.techtown.dontlate.model.ReverseGeocoding;
import org.techtown.dontlate.model.ReverseLabel;
import org.techtown.dontlate.model.SearchPoiInfo;
import org.techtown.dontlate.model.TrafficInfo;
import org.techtown.dontlate.model.TransAddress;
import org.techtown.dontlate.model.TransCoord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class navigationss extends Fragment implements TMapGpsManager.onLocationChangedCallback {


    private View view;
    private Button button;

    TMapView tMapView = null;
    TMapGpsManager tMapGps = null;

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.navigations, container, false);

        Button search = (Button) v.findViewById(R.id.button2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), transportss.class);
                startActivity(intent);
            }
        });





        tMapView = new TMapView(getActivity());

        tMapView.setSKTMapApiKey("l7xxddf8547d834c4053946c4a168738d92f");

        tMapView.setZoomLevel(17);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);

        LinearLayout linearLayoutTmap = (LinearLayout) v.findViewById(R.id.linearLayoutTmap);
        linearLayoutTmap.addView(tMapView);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        tMapGps = new TMapGpsManager(getActivity());

        tMapGps.setMinTime(1000);
        tMapGps.setMinDistance(10);
        tMapGps.setProvider(tMapGps.NETWORK_PROVIDER);

        tMapGps.OpenGps();


        return v;
    }
    @Override
    public void onLocationChange(Location location){
        tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
        tMapView.setCenterPoint(location.getLongitude(), location.getLatitude());
    }
//    public void callSearchPoiInfo() {
//
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String> data = new HashMap<>();
//        data.put("version", String.valueOf(1));
//        data.put("searchKeyword", "빈스빈스 마포 공덕점" );
//        data.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getSearch(data).enqueue(new Callback<PoiSearch>() {
//            @Override
//            public void onResponse(Call<PoiSearch> call, Response<PoiSearch> response) {
//                PoiSearch poiSearch = response.body();
//                Log.d("test", response.message().toString());
//                Log.d("test", String.valueOf(poiSearch.getSearchPoiInfo().getPois().getPoi().get(0).getName()));
//            }
//
//            @Override
//            public void onFailure(Call<PoiSearch> call, Throwable t) {
//                Log.d("test", t.toString());
//            }
//        });
//
//    }
//




}
