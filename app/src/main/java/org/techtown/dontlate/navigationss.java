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
import org.techtown.dontlate.model.FullTextGeocoding;
import org.techtown.dontlate.model.Geocoding;
import org.techtown.dontlate.model.NearRoad;
import org.techtown.dontlate.model.PoiCategory;
import org.techtown.dontlate.model.PoiDetailSearch;
import org.techtown.dontlate.model.PoiSearch;
import org.techtown.dontlate.model.PostSearch;
import org.techtown.dontlate.model.RegionDivide;
import org.techtown.dontlate.model.ReverseGeocoding;
import org.techtown.dontlate.model.ReverseLabel;
import org.techtown.dontlate.model.SearchPoiInfo;
import org.techtown.dontlate.model.TransAddress;
import org.techtown.dontlate.model.TransCoord;

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
//        callSearchRGC();
//        callSearchGC();
//        callSearchFTGC();
//        callSearchTC();
//        callSearchTA();
//        callSearchNR();
//        callSearchPost();
//        callSearchRL();









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

//    public void callSearchRGC() {
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>rgdata = new HashMap<>();
//
//        rgdata.put("version", String.valueOf(1));
//        rgdata.put("lat", "37.739874");
//        rgdata.put("lon", "127.057990");
//        rgdata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getRGSearch(rgdata).enqueue(new Callback<ReverseGeocoding>() {
//            @Override
//            public void onResponse(Call<ReverseGeocoding> call, Response<ReverseGeocoding> response) {
//                ReverseGeocoding reverseGeocoding = response.body();
//                Log.d("testRGC", reverseGeocoding.getAddressInfo().getCityDo());
//            }
//
//            @Override
//            public void onFailure(Call<ReverseGeocoding> call, Throwable t) {
//                Log.d("testRGC", t.toString());
//            }
//        });
//    }


//    public void callSearchGC() {
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>gcdata = new HashMap<>();
//        gcdata.put("version", String.valueOf(1));
//        gcdata.put("city_do", "%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C");
//        gcdata.put("gu_gun", "%EA%B0%95%EC%84%9C%EA%B5%AC");
//        gcdata.put("dong", "%ED%99%94%EA%B3%A1%EB%8F%99");
//        gcdata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getGSearch(gcdata).enqueue(new Callback<Geocoding>() {
//            @Override
//            public void onResponse(Call<Geocoding> call, Response<Geocoding> response) {
//                Geocoding geocoding = response.body();
//                Log.d("testG", geocoding.getCoordinateInfo().getCityDo());
//            }
//
//            @Override
//            public void onFailure(Call<Geocoding> call, Throwable t) {
//                Log.d("testG", t.toString());
//            }
//        });
//    }

//    public void callSearchFTGC(){
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>ftdata = new HashMap<>();
//        ftdata.put("version", "1");
//        ftdata.put("addressFlag", "F00");
//        ftdata.put("fullAddr", "서울특별시 영등포구 당산로 214, 422동 3001호");
//        ftdata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getFTGSearch(ftdata).enqueue(new Callback<FullTextGeocoding>() {
//            @Override
//            public void onResponse(Call<FullTextGeocoding> call, Response<FullTextGeocoding> response) {
//                FullTextGeocoding fullTextGeocoding = response.body();
//                Log.d("testFTG", fullTextGeocoding.getCoordinateInfo().getCoordinate().get(0).getCityDo());
//            }
//
//            @Override
//            public void onFailure(Call<FullTextGeocoding> call, Throwable t) {
//                Log.d("testFTG", t.toString());
//            }
//        });
//    }

//    public void callSearchTC() {
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>tcdata = new HashMap<>();
//        tcdata.put("version", String.valueOf(1));
//        tcdata.put("lat", "37.5446283608815");
//        tcdata.put("lon", "126.83529138565");
//        tcdata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getTCSearch(tcdata).enqueue(new Callback<TransCoord>() {
//            @Override
//            public void onResponse(Call<TransCoord> call, Response<TransCoord> response) {
//                TransCoord transCoord = response.body();
//                Log.d("testTC", transCoord.getCoordinate().getLat());
//            }
//
//            @Override
//            public void onFailure(Call<TransCoord> call, Throwable t) {
//                Log.d("testTC", t.toString());
//            }
//        });
//    }

//    public void callSearchTA() {
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>tadata = new HashMap<>();
//        tadata.put("version", String.valueOf(1));
//        tadata.put("searchTypCd", "NtoO");
//        tadata.put("reqAdd", "경기도 성남시 분당구 판교로 264");
//        tadata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getTASearch(tadata).enqueue(new Callback<TransAddress>() {
//            @Override
//            public void onResponse(Call<TransAddress> call, Response<TransAddress> response) {
//                TransAddress transAddress = response.body();
//                Log.d("testTA", transAddress.getConvertAdd().getLegalLowerDistName());
//            }
//
//            @Override
//            public void onFailure(Call<TransAddress> call, Throwable t) {
//                Log.d("testTA", t.toString());
//            }
//        });
//    }

//    public void callSearchNR() {
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>nrdata = new HashMap<>();
//        nrdata.put("version", "1");
//        nrdata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//        nrdata.put("lat", "37.556542");
//        nrdata.put("lon", "127.925710");
//
//        retrofitInterface.getNRSearch(nrdata).enqueue(new Callback<NearRoad>() {
//            @Override
//            public void onResponse(Call<NearRoad> call, Response<NearRoad> response) {
//                NearRoad nearRoad = response.body();
//                Log.d("TestNR", nearRoad.getResultData().getHeader().getIdxName());
//            }
//
//            @Override
//            public void onFailure(Call<NearRoad> call, Throwable t) {
//                Log.d("TestNR", t.toString());
//            }
//        });
//    } //resultData 내부 값이 비어있는데 왜 비어있는지를 모르겠음.

//    public void callSearchPost() {
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>podata = new HashMap<>();
//        podata.put("version", "1");
//        podata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//        podata.put("addr", "%EC%84%9C%EC%9A%B8%EC%8B%9C+%EA%B0%95%EB%82%A8%EA%B5%AC+%EC%8B%A0%EC%82%AC%EB%8F%99");
//        podata.put("addressFlag", "F00");
//
//        retrofitInterface.getPostSearch(podata).enqueue(new Callback<PostSearch>() {
//            @Override
//            public void onResponse(Call<PostSearch> call, Response<PostSearch> response) {
//                PostSearch postSearch = response.body();
//                Log.d("testPost", postSearch.getCoordinateInfo().getCoordinate().get(0).getCityDo());
//            }
//
//            @Override
//            public void onFailure(Call<PostSearch> call, Throwable t) {
//                Log.d("testPost", t.toString());
//            }
//        });
//    }

//    public void callSearchRL() {
//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//
//        HashMap<String, String>rvdata = new HashMap<>();
//        rvdata.put("version", String.valueOf(1));
//        rvdata.put("format", "json");
//        rvdata.put("centerLat", "37.556613");
//        rvdata.put("centerLon", "126.89889");
//        rvdata.put("reqLevel", String.valueOf(15));
//        rvdata.put("appKey", "l7xxddf8547d834c4053946c4a168738d92f");
//
//        retrofitInterface.getRLSearch(rvdata).enqueue(new Callback<ReverseLabel>() {
//            @Override
//            public void onResponse(Call<ReverseLabel> call, Response<ReverseLabel> response) {
//                ReverseLabel reverseLabel = response.body();
//                Log.d("testRL", reverseLabel.getPoiInfo().getPoiLat());
//            }
//
//            @Override
//            public void onFailure(Call<ReverseLabel> call, Throwable t) {
//                Log.d("testRL",t.toString());
//            }
//        });
//    } //얘도 오류나네 null값
}
