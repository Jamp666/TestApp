package com.example.testapp.accuweatherapi;

import com.example.testapp.pojo.ConditionsPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AccuWeatherCurrentConditions {
        @GET("currentconditions/v1/{key}")
        Call<List<ConditionsPOJO>> getConditions(@Path("key") String key,
                                                 @Query(value = "apikey") String apikey);
}
