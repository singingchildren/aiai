package com.example.firstday.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:${张四佟}
 * date:2019/2/12 18:49
 * description
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
