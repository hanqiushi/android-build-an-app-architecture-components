package com.example.android.sunshine.dagger2;

import com.example.android.sunshine.ui.detail.DetailActivity;
import com.example.android.sunshine.ui.list.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(DetailActivity activity);
}
