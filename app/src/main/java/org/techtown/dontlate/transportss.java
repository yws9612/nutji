package org.techtown.dontlate;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.techtown.dontlate.model_odsay.BusRoute;
import org.techtown.dontlate.model_odsay.BusRouteInfo;
import org.techtown.dontlate.model_odsay.CityCode;
import org.techtown.dontlate.model_odsay.PublicTransitPOI;
import org.techtown.dontlate.model_odsay.PublicTransitPOIMap;
import org.techtown.dontlate.model_odsay.PublicTransitStop;
import org.techtown.dontlate.model_odsay.RadiusRoute;
import org.techtown.dontlate.model_odsay.RouteGraph;
import org.techtown.dontlate.model_odsay.RouteSearch;
import org.techtown.dontlate.model_odsay.SubRoute;
import org.techtown.dontlate.model_odsay.SubStationInfo;
import org.techtown.dontlate.model_odsay.SubTimetable;
import org.techtown.dontlate.model_odsay.SubTransfer;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class transportss extends Fragment {

    private View view;

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transports, container, false);

        CALL_BUS_ROUTE();
        CALL_BUS_ROUTE_INFO();
        CALL_SUB_STATION_INFO();
        CALL_SUB_TIMETABLE();
        CALL_ROUTE_GRAPH();
        CALL_PUBLIC_TRANSIT_STOP();
        CALL_PUBLIC_TRANSIT_POI();
        CALL_PUBLIC_TRANSIT_POI_MAP();
        CALL_SUB_ROUTE();
        CALL_ROUTE_SEARCH();
        CALL_SUB_TRANSFER();
        CALL_CITY_CODE();
        CALL_RADIUS_ROUTE();
        CALL_BUS_LOCATION();

        return view;
    }

    public void CALL_BUS_ROUTE() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Integer> data = new HashMap<>();

        retrofitInterface.BUS_ROUTE_CALL(data).enqueue(new Callback<BusRoute>() {
            @Override
            public void onResponse(Call<BusRoute> call, Response<BusRoute> response) {
                BusRoute busRoute = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(busRoute.getLane()));
            }

            @Override
            public void onFailure(Call<BusRoute> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_BUS_ROUTE_INFO() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Integer> data = new HashMap<>();

        retrofitInterface.BUS_ROUTE_INFO_CALL(data).enqueue(new Callback<BusRouteInfo>() {
            @Override
            public void onResponse(Call<BusRouteInfo> call, Response<BusRouteInfo> response) {
                BusRouteInfo busRouteInfo = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(busRouteInfo.getBusTotalDistance()));
            }

            @Override
            public void onFailure(Call<BusRouteInfo> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_SUB_STATION_INFO() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Integer> data = new HashMap<>();

        retrofitInterface.SUB_STATION_INFO_CALL(data).enqueue(new Callback<SubStationInfo>() {
            @Override
            public void onResponse(Call<SubStationInfo> call, Response<SubStationInfo> response) {
                SubStationInfo subStationInfo = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(subStationInfo.getStationName()));
            }

            @Override
            public void onFailure(Call<SubStationInfo> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_SUB_TIMETABLE() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Integer> data = new HashMap<>();

        retrofitInterface.SUB_TIMETABLE_CALL(data).enqueue(new Callback<SubTimetable>() {
            @Override
            public void onResponse(Call<SubTimetable> call, Response<SubTimetable> response) {
                SubTimetable subTimetable = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(subTimetable.getStationName()));
            }

            @Override
            public void onFailure(Call<SubTimetable> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_ROUTE_GRAPH() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, String> data = new HashMap<>();

        retrofitInterface.ROUTE_GRAPH_CALL(data).enqueue(new Callback<RouteGraph>() {
            @Override
            public void onResponse(Call<RouteGraph> call, Response<RouteGraph> response) {
                RouteGraph routeGraph = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(routeGraph.getBoundary()));
            }

            @Override
            public void onFailure(Call<RouteGraph> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_PUBLIC_TRANSIT_STOP() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, String> data = new HashMap<>();

        retrofitInterface.PUBLIC_TRANSIT_STOP_CALL(data).enqueue(new Callback<PublicTransitStop>() {
            @Override
            public void onResponse(Call<PublicTransitStop> call, Response<PublicTransitStop> response) {
                PublicTransitStop publicTransitStop = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(publicTransitStop.getTotalCityList()));
            }

            @Override
            public void onFailure(Call<PublicTransitStop> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_PUBLIC_TRANSIT_POI() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, String> data = new HashMap<>();

        retrofitInterface.PUBLIC_TRANSIT_POI_CALL(data).enqueue(new Callback<PublicTransitPOI>() {
            @Override
            public void onResponse(Call<PublicTransitPOI> call, Response<PublicTransitPOI> response) {
                PublicTransitPOI publicTransitPOI = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(publicTransitPOI.getStation()));
            }

            @Override
            public void onFailure(Call<PublicTransitPOI> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_PUBLIC_TRANSIT_POI_MAP() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, String> data = new HashMap<>();

        retrofitInterface.PUBLIC_TRANSIT_POI_MAP_CALL(data).enqueue(new Callback<PublicTransitPOIMap>() {
            @Override
            public void onResponse(Call<PublicTransitPOIMap> call, Response<PublicTransitPOIMap> response) {
                PublicTransitPOIMap publicTransitPOIMap = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(publicTransitPOIMap.getStation()));
            }

            @Override
            public void onFailure(Call<PublicTransitPOIMap> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_SUB_ROUTE() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Integer> data = new HashMap<>();

        retrofitInterface.SUB_ROUTE_CALL(data).enqueue(new Callback<SubRoute>() {
            @Override
            public void onResponse(Call<SubRoute> call, Response<SubRoute> response) {
                SubRoute subRoute = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(subRoute.getStationSet()));
            }

            @Override
            public void onFailure(Call<SubRoute> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_ROUTE_SEARCH() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Double> data = new HashMap<>();

        retrofitInterface.ROUTE_SEARCH_CALL(data).enqueue(new Callback<RouteSearch>() {
            @Override
            public void onResponse(Call<RouteSearch> call, Response<RouteSearch> response) {
                RouteSearch routeSearch = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(routeSearch.getPath()));
            }

            @Override
            public void onFailure(Call<RouteSearch> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_SUB_TRANSFER() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Integer> data = new HashMap<>();

        retrofitInterface.SUB_TRANSFER_CALL(data).enqueue(new Callback<SubTransfer>() {
            @Override
            public void onResponse(Call<SubTransfer> call, Response<SubTransfer> response) {
                SubTransfer subTransfer = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(subTransfer.getTransitTotalInfo()));
            }

            @Override
            public void onFailure(Call<SubTransfer> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_CITY_CODE() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, String> data = new HashMap<>();

        retrofitInterface.CITY_CODE_CALL(data).enqueue(new Callback<CityCode>() {
            @Override
            public void onResponse(Call<CityCode> call, Response<CityCode> response) {
                CityCode cityCode = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(cityCode.getCid()));
            }

            @Override
            public void onFailure(Call<CityCode> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_RADIUS_ROUTE() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Double> data = new HashMap<>();

        retrofitInterface.RADIUS_ROUTE_CALL(data).enqueue(new Callback<RadiusRoute>() {
            @Override
            public void onResponse(Call<RadiusRoute> call, Response<RadiusRoute> response) {
                RadiusRoute radiusRoute = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(radiusRoute.getLane()));
            }

            @Override
            public void onFailure(Call<RadiusRoute> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }

    public void CALL_BUS_LOCATION() {

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        HashMap<Integer, Integer> data = new HashMap<>();

        retrofitInterface.BUS_ROUTE_CALL(data).enqueue(new Callback<BusRoute>() {
            @Override
            public void onResponse(Call<BusRoute> call, Response<BusRoute> response) {
                BusRoute busRoute = response.body();
                Log.d("test", response.message().toString());
                Log.d("test", String.valueOf(busRoute.getLane()));
            }

            @Override
            public void onFailure(Call<BusRoute> call, Throwable t) {
                Log.d("test", t.toString());
            }
        });
    }
}
