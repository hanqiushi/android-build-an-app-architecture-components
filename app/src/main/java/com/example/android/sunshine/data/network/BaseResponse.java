package com.example.android.sunshine.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse<T> {

    @Expose
    @SerializedName("city")
    private City mCity;

    public static class City {
        @SerializedName("id")
        private String mId;

        @SerializedName("name")
        private String mName;

        @SerializedName("coord")
        private Coord mCoord;

        public static class Coord {
            @SerializedName("lon")
            private String mLon;

            @SerializedName("lat")
            private String mLat;
        }

        @SerializedName("country")
        private String mCountry;

        @SerializedName("population")
        private String mPopulation;
    }

    @Expose
    @SerializedName("cod")
    private String mCodeInt;

    @Expose
    @SerializedName("message")
    private String mMessage;

    @Expose
    @SerializedName("cnt")
    private String mCount;

    @Expose
    @SerializedName("list")
    private T mData;

    public BaseResponse() {
    }

    public String getCodeIntRaw() {
        return mCodeInt;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
