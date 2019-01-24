package com.example.android.sunshine.data.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WeatherRetrofit {

    /* The query parameter allows us to provide a location string to the API */
    String QUERY_PARAM = "q";
    /* The format parameter allows us to designate whether we want JSON or XML from our API */
    String FORMAT_PARAM = "mode";
    /* The units parameter allows us to designate whether we want metric units or imperial units */
    String UNITS_PARAM = "units";
    /* The days parameter allows us to designate how many days of weather data we want */
    String DAYS_PARAM = "cnt";

    @GET("weather")
    Observable<BaseResponse<List<WeatherData>>> getWeather(
            @Query(QUERY_PARAM) String location,
            @Query(FORMAT_PARAM) String mode,
            @Query(UNITS_PARAM) String units,
            @Query(DAYS_PARAM) String days
    );

}
