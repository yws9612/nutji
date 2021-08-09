package org.techtown.dontlate;

import org.techtown.dontlate.model.PoiCategory;
import org.techtown.dontlate.model.PoiDetailSearch;
import org.techtown.dontlate.model.PoiSearch;


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

    @GET("https://apis.openapi.sk.com/tmap/pois/search/around")
    Call <PoiCategory> getPoiCategory(@QueryMap HashMap<String, String> options);


}

