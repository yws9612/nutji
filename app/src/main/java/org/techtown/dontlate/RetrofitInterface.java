package org.techtown.dontlate;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=127.1086228&y=37.4012191")
    Call<Result> AddressInfo(@Query("x") String x, @Query("y") String y, @Query("input_coord") String input_coord, @Query("output_coord") String output_coord);
}
