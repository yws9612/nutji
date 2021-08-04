package org.techtown.dontlate;

import org.techtown.dontlate.model.CoordRegionInfo;
import org.techtown.dontlate.model.SearchingAddress;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("v2/local/geo/coord2regioncode.json")
    Call<CoordRegionInfo> RegionInfo(@Header("Authorization") String authorization, @Query("x") String x, @Query("y") String y);

    @GET("v2/local/search/address.json")
    Call<SearchingAddress> AddressInfo(@Header("Authorization") String authorization, @Query("query") String query);
}
