package com.example.lastwork.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:${张四佟}
 * date:2019/3/2 9:44
 * description
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
