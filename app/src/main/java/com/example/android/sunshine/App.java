package com.example.android.sunshine;

import android.app.Application;

import com.example.android.sunshine.dagger2.AppComponent;
import com.example.android.sunshine.dagger2.AppModule;
import com.example.android.sunshine.dagger2.DaggerAppComponent;

public class App extends Application {

    private static AppComponent appComponent;
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initDagger();
    }

    public AppComponent getComponent() {
        return appComponent;
    }

    public static App getInstance() {
        return sInstance;
    }

    public void initDagger() {
        appComponent = DaggerAppComponent.builder()
                //.applicationModule(new AppModule(this))
                .build();
    }
}
