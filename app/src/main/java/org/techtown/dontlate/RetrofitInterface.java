package org.techtown.dontlate;

import org.techtown.dontlate.model.AreaSearching;
import org.techtown.dontlate.model.CarNavigate;
import org.techtown.dontlate.model.DirectDistance;
import org.techtown.dontlate.model.EupMyunDongSearch;
import org.techtown.dontlate.model.FullTextGeocoding;
import org.techtown.dontlate.model.Geocoding;
import org.techtown.dontlate.model.MatchToRoad;
import org.techtown.dontlate.model.NamePoiDetailSearch;
import org.techtown.dontlate.model.NearPoiDetailSearch;
import org.techtown.dontlate.model.NearRoad;
import org.techtown.dontlate.model.PersonNavigate;
import org.techtown.dontlate.model.PoiCategory;
import org.techtown.dontlate.model.PoiDetailSearch;
import org.techtown.dontlate.model.PoiSearch;
import org.techtown.dontlate.model.PostSearch;
import org.techtown.dontlate.model.RegionDivide;
import org.techtown.dontlate.model.RegionSearching;
import org.techtown.dontlate.model.ReverseGeocoding;
import org.techtown.dontlate.model.ReverseLabel;
import org.techtown.dontlate.model.StaticMap;
import org.techtown.dontlate.model.TMCarRoutes;
import org.techtown.dontlate.model.TrafficInfo;
import org.techtown.dontlate.model.TransAddress;
import org.techtown.dontlate.model.TransCoord;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

//    ---------------------------POI 검색 API 세팅------------------------------------------
    @GET("tmap/pois")
    Call <PoiSearch> getSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/pois/{poiInfo}")
    Call <PoiDetailSearch> getDetailSearch(@Path("poiInfo") String poiInfo, @QueryMap HashMap<String, String> options);

    @GET("tmap/pois/search/around")
    Call <PoiCategory> getPoiCategory(@QueryMap HashMap<String, String> options);

    @GET("tmap/poi/findPoiAreaDataByName")
    Call <EupMyunDongSearch> getEMDSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/poi/areascode")
    Call <RegionDivide> getCodeSearch(@QueryMap HashMap<String, String> options);

//    ---------------------------지오코딩 API 세팅------------------------------------------

    @GET("tmap/geo/reversegeocoding")
    Call <ReverseGeocoding> getRGSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/geo/geocoding")
    Call <Geocoding> getGSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/geo/fullAddrGeo")
    Call <FullTextGeocoding> getFTGSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/geo/coordconvert")
    Call <TransCoord> getTCSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/geo/convertAddress")
    Call <TransAddress> getTASearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/road/nearToRoad")
    Call <NearRoad> getNRSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/geo/postcode")
    Call <PostSearch> getPostSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/geo/reverseLabel")
    Call <ReverseLabel> getRLSearch(@QueryMap HashMap<String, String> options);

//    -------------------------지오펜싱 API 세팅-----------------------------
    @GET("tmap/geofencing/regions")
    Call <AreaSearching> getAreaSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/geofencing/regions/{regionId}")
    Call <RegionSearching> getRegionSearch(@Path("regionId") String regionId, @QueryMap HashMap<String, String> options);

//        -------------------------교통정보 API 세팅-----------------------------
    @GET("tmap/traffic")
    Call <TrafficInfo> getTISearch(@QueryMap HashMap<String, String> options);

//        -------------------------경로안내 API 세팅------------------------------
    @FormUrlEncoded
    @POST("tmap/routes/prediction")
    Call <TMCarRoutes> getTMCRRSearch(@FieldMap HashMap<String, Object> param);

    @GET("tmap/routes/distance")
    Call <DirectDistance> getDDSearch(@QueryMap HashMap<String, String> options);

    @FormUrlEncoded
    @POST("tmap/routes/pedestrian")
    Call <PersonNavigate> getPNSearch(@FieldMap HashMap<String, Object> param);

    @FormUrlEncoded
    @POST("tmap/routes")
    Call <CarNavigate> getCNSearch(@FieldMap HashMap<String, Object> param);

//        -------------------------ROAD API 세팅------------------------------
    @FormUrlEncoded
    @POST("tmap/road/matchToRoads")
    Call <MatchToRoad> getMTRSearch(@FieldMap HashMap<String, Object> param);

//        -------------------------StaticMap API 세팅------------------------------
    @GET("tmap/staticMap")
    Call <StaticMap> getSMSearch(@QueryMap HashMap<String, String> options);

//        -------------------------유가 정보 API 세팅------------------------------
    @GET("tmap/oilinfo/aroundOil")
    Call <NearPoiDetailSearch> getNPDSearch(@QueryMap HashMap<String, String> options);

    @GET("tmap/oilinfo/poiDetailOil")
    Call <NamePoiDetailSearch> getNaPDSearch(@QueryMap HashMap<String ,String> options);

}

