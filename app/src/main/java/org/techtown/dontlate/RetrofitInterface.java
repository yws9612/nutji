package org.techtown.dontlate;

import org.techtown.dontlate.model.NaviAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RetrofitInterface {
//저거 없애니까 중단뜨네
    @GET("v2/local/geo/coord2regioncode.json")//녱
    Call<NaviAPI> AddressInfo(@Header("Authorization") String authorization, @Query("x") String x, @Query("y") String y);
}
///잠시만요