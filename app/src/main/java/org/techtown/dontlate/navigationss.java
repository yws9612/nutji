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

import org.techtown.dontlate.model.EupMyunDongSearch;
import org.techtown.dontlate.model.PoiCategory;
import org.techtown.dontlate.model.PoiDetailSearch;
import org.techtown.dontlate.model.PoiSearch;
import org.techtown.dontlate.model.RegionDivide;
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





//        callSearchPoiInfo();
//        callSearchDetailInfo();
//        callSearchCategory();
//        callSearchEMD();
//        callSearchCode();









        return v;
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
//    public void callSearchDetailInfo() {
//
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//
//        HashMap<String, String> dedata = new HashMap<>();
//        dedata.put("version", String.valueOf(1));
//        dedata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//        dedata.put("resCoordType", "WGS84GEO");
//        dedata.put("callback", "function");
//
//
//        retrofitInterface.getDetailSearch("4670161",dedata).enqueue(new Callback<PoiDetailSearch>() {
//            @Override
//            public void onResponse(Call<PoiDetailSearch> call, Response<PoiDetailSearch> response) {
//                PoiDetailSearch poiDetailSearch = response.body();
//                Log.d("testde", poiDetailSearch.getPoiDetailInfo().getAddress());
//            }
//
//            @Override
//            public void onFailure(Call<PoiDetailSearch> call, Throwable t) {
//                Log.d("testde", t.toString());
//
//            }
//        });
//    }
//
//    public void callSearchCategory() {
//
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//
//        HashMap<String, String>cadata = new HashMap<>();
//        cadata.put("version", String.valueOf(1));
//        cadata.put("centerLon", String.valueOf(127.027621));
//        cadata.put("centerLat", String.valueOf(37.497916));
//        cadata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//
//        retrofitInterface.getPoiCategory(cadata).enqueue(new Callback<PoiCategory>() {
//            @Override
//            public void onResponse(Call<PoiCategory> call, Response<PoiCategory> response) {
//                PoiCategory poiCategory = response.body();
//                Log.d("testCa", poiCategory.getSearchPoiInfo().getPois().getPoi().get(0).getName());
//            }
//
//            @Override
//            public void onFailure(Call<PoiCategory> call, Throwable t) {
//                Log.d("testCa", t.toString());
//            }
//        });
//    }

//    public void callSearchEMD(){
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>emddata = new HashMap<>();
//        emddata.put("version", String.valueOf(1));
//        emddata.put("page", String.valueOf(1));
//        emddata.put("count", String.valueOf(1));
//        emddata.put("area_dong", "성내동");
//        emddata.put("appKey","l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getEMDSearch(emddata).enqueue(new Callback<EupMyunDongSearch>() {
//            @Override
//            public void onResponse(Call<EupMyunDongSearch> call, Response<EupMyunDongSearch> response) {
//                EupMyunDongSearch eupMyunDongSearch = response.body();
//                Log.d("testEMD", eupMyunDongSearch.getFindPoiAreaDataByNameInfo().getDongInfo().get(0).getAddress());
//            }
//
//            @Override
//            public void onFailure(Call<EupMyunDongSearch> call, Throwable t) {
//                Log.d("testEMD", t.toString());
//            }
//        });
//    }

//    public void callSearchCode() {
//
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>codata = new HashMap<>();
//
//        codata.put("version", "1");
//        codata.put("count", "10");
//        codata.put("page", "1");
//        codata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getCodeSearch(codata).enqueue(new Callback<RegionDivide>() {
//            @Override
//            public void onResponse(Call<RegionDivide> call, Response<RegionDivide> response) {
//                RegionDivide regionDivide = response.body();
//                Log.d("testco", regionDivide.getAreaCodeInfo().getPoiAreaCodes().get(0).getDistrictName());
//            }
//
//            @Override
//            public void onFailure(Call<RegionDivide> call, Throwable t) {
//                Log.d("testco", t.toString());
//            }
//        });
//    }

}
