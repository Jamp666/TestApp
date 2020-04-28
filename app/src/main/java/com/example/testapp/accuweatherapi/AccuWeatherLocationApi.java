package com.example.testapp.accuweatherapi;

import com.example.testapp.pojo.LocationPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccuWeatherLocationApi {
        @GET("/locations/v1/cities/search")
        Call<List<LocationPOJO>> getKey(@Query(value = "apikey") String apikey,
                                        @Query(value = "q") String q);
}
