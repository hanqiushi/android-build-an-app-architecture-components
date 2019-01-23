package com.example.android.sunshine.dagger2;

import android.arch.persistence.room.Room;
import android.util.Log;

import com.example.android.sunshine.App;
import com.example.android.sunshine.AppExecutors;
import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.SunshineDatabase;
import com.example.android.sunshine.data.database.WeatherDao;
import com.example.android.sunshine.data.network.WeatherNetworkDataSource;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    SunshineDatabase mSunshineDatabase;
    AppExecutors mAppExecutors;
    WeatherNetworkDataSource mWeatherNetworkDataSource;
    private static final Object LOCK = new Object();

    @Singleton
    @Provides
    SunshineDatabase provideSunshieDatabase() {
        if (mSunshineDatabase == null) {
            synchronized (LOCK) {
                mSunshineDatabase = Room.databaseBuilder(App.getInstance().getApplicationContext(),
                        SunshineDatabase.class, SunshineDatabase.DATABASE_NAME).build();
            }
        }
        return mSunshineDatabase;
    }

    @Singleton
    @Provides
    AppExecutors provideAppExecutors() {
        if (mAppExecutors == null) {
            synchronized (LOCK) {
                mAppExecutors = new AppExecutors(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        new AppExecutors.MainThreadExecutor());
            }
        }
        return mAppExecutors;
    }

    @Singleton
    @Provides
    WeatherNetworkDataSource provideNetworkDataSource(AppExecutors executors) {
        if (mWeatherNetworkDataSource == null) {
            synchronized (LOCK) {
                mWeatherNetworkDataSource = new WeatherNetworkDataSource(App.getInstance().getApplicationContext(), executors);
            }
        }
        return mWeatherNetworkDataSource;
    }

    @Singleton
    @Provides
    WeatherDao provideWeatherDao() {
        if (mSunshineDatabase == null) {
            provideSunshieDatabase();
        }
        return mSunshineDatabase.weatherDao();
    }
}
