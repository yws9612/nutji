package org.techtown.dontlate;

import org.techtown.dontlate.model.PoiDetailSearch;
import org.techtown.dontlate.model.PoiSearch;
import org.techtown.dontlate.model_odsay.BusLocation;
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
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

    @GET("https://apis.openapi.sk.com/tmap/pois")
    Call <PoiSearch> getSearch(@QueryMap HashMap<String, String> options);

    @GET("https://apis.openapi.sk.com/tmap/pois/{poiInfo}")
    Call <PoiDetailSearch> getDetailSearch(@Path("poiInfo") String poiInfo, @QueryMap HashMap<String, String> options);


}

