package com.example.testapp;

import com.example.testapp.accuweatherapi.AccuWeatherCurrentConditions;
import com.example.testapp.accuweatherapi.AccuWeatherLocationApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class NetworkService {
        private static NetworkService mInstance;
        private static final String BASE_URL = "http://dataservice.accuweather.com";
        private Retrofit mRetrofit;

        private NetworkService() {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder client = new OkHttpClient.Builder().addInterceptor(interceptor);

                mRetrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client.build())
                        .build();
        }

        static NetworkService getInstance() {
                if (mInstance == null) {
                        mInstance = new NetworkService();
                }
                return mInstance;
        }

        AccuWeatherLocationApi getLocationApi() {
                return mRetrofit.create(AccuWeatherLocationApi.class);
        }

        AccuWeatherCurrentConditions getConditionsApi() {
                return mRetrofit.create(AccuWeatherCurrentConditions.class);
        }
}
