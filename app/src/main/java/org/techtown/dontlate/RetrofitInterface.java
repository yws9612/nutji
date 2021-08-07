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
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

    @GET("https://apis.openapi.sk.com/tmap/pois")
    Call <PoiSearch> getSearch(@QueryMap HashMap<String, String> options);

    @GET("https://apis.openapi.sk.com/tmap/pois")
    Call <PoiDetailSearch> getDetailSearch(@Header("poiInfo") String poiInfo, @QueryMap HashMap<String, String> options);

    //--------------------------------------------------------------여기부터 ODSay--------------------------------------------------------------------------

    @GET("https://api.odsay.com/v1/api/searchBusLane")
    Call <BusRoute> BUS_ROUTE_CALL(@QueryMap HashMap<Integer, Integer> options);

    @GET("https://api.odsay.com/v1/api/busLaneDetail")
    Call <BusRouteInfo> BUS_ROUTE_INFO_CALL(@QueryMap HashMap<Integer, Integer> options);

    @GET("https://api.odsay.com/v1/api/subwayStationInfo")
    Call <SubStationInfo> SUB_STATION_INFO_CALL(@QueryMap HashMap<Integer, Integer> options);

    @GET("https://api.odsay.com/v1/api/subwayTimeTable")
    Call <SubTimetable> SUB_TIMETABLE_CALL(@QueryMap HashMap<Integer, Integer> options);

    @GET("https://api.odsay.com/v1/api/loadLane")
    Call <RouteGraph> ROUTE_GRAPH_CALL(@QueryMap HashMap<Integer, String> options);

    @GET("https://api.odsay.com/v1/api/searchStation")
    Call <PublicTransitStop> PUBLIC_TRANSIT_STOP_CALL(@QueryMap HashMap<Integer, String> options);

    @GET("https://api.odsay.com/v1/api/pointSearch")
    Call <PublicTransitPOI> PUBLIC_TRANSIT_POI_CALL(@QueryMap HashMap<Integer, String> options);

    @GET("https://api.odsay.com/v1/api/boundarySearch")
    Call <PublicTransitPOIMap> PUBLIC_TRANSIT_POI_MAP_CALL(@QueryMap HashMap<Integer, String> options);

    @GET("https://api.odsay.com/v1/api/subwayPath")
    Call <SubRoute> SUB_ROUTE_CALL(@QueryMap HashMap<Integer, Integer> options);

    @GET("https://api.odsay.com/v1/api/searchPubTransPathR")
    Call <RouteSearch> ROUTE_SEARCH_CALL(@QueryMap HashMap<Integer, Double> options);

    @GET("https://api.odsay.com/v1/api/subwayTransitInfo")
    Call <SubTransfer> SUB_TRANSFER_CALL(@QueryMap HashMap<Integer, Integer> options);

    @GET("https://api.odsay.com/v1/api/searchCID")
    Call <CityCode> CITY_CODE_CALL(@QueryMap HashMap<Integer, String> options);

    @GET("https://api.odsay.com/v1/api/pointBusStation")
    Call <RadiusRoute> RADIUS_ROUTE_CALL(@QueryMap HashMap<Integer, Double> options);

    @GET("https://api.odsay.com/v1/api/realtimeRoute")
    Call <BusLocation> BUS_LOCATION_CALL(@QueryMap HashMap<Integer, Integer> options);
}

