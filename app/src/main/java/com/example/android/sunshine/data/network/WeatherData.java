package com.example.android.sunshine.data.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {

    @SerializedName("dt")
    private String mDt;

    @SerializedName("temp")
    private Temp mTemp;

    public static class Temp {
        @SerializedName("day")
        private String mDay;

        @SerializedName("min")
        private String mMin;

        @SerializedName("max")
        private String mMax;

        @SerializedName("night")
        private String mNight;

        @SerializedName("eve")
        private String mEve;

        @SerializedName("morn")
        private String mMorn;
    }

    @SerializedName("pressure")
    private String mPressure;

    @SerializedName("humidity")
    private String mHumidity;

    @SerializedName("weather")
    private List<Weather> mWeather;

    public static class Weather{
        @SerializedName("id")
        private String mId;

        @SerializedName("main")
        private String mMain;

        @SerializedName("description")
        private String mDescription;

        @SerializedName("icon")
        private String mIcon;
    }

    @SerializedName("speed")
    private String mSpeed;

    @SerializedName("deg")
    private String mDeg;

    @SerializedName("clouds")
    private String mClouds;

    @Override
    public String toString() {
        return super.toString();
    }
}
